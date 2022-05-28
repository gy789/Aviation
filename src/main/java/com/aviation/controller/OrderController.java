package com.aviation.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.aviation.entity.*;
import com.aviation.service.*;
import com.aviation.util.AlipayConfig;
import com.aviation.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/")
public class OrderController {


    @Autowired(required = false)
    private OrdersService ordersService;

    @Autowired(required = false)
    private FlightService flightService;
    @Autowired(required = false)
    private SeatService seatService;
    @Autowired(required = false)
    private PeopleService peopleService;
    @Autowired(required = false)
    private CompanyService companyService;


    @RequestMapping("makeorder")
    public String MakeOrder(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Users users = (Users)session.getAttribute("user");
        String flight_id = request.getParameter("flight_id");
        String date = request.getParameter("date");
        if (date.equals("")){
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.format(now);
        }

        Flight flight = flightService.getFlightInfo(flight_id);
        Orders orders = new Orders();
        orders.setFlight_start(flight.getFlight_start());
        orders.setFlight_end(flight.getFlight_end());
        orders.setFlight_start_time(flight.getFlight_start_time());
        orders.setFlight_arrive_time(flight.getFlight_arrive_time());
        orders.setCompany_name(flight.getCompany_name());
        orders.setOrder_price(String.valueOf(Integer.parseInt(flight.getFlight_price())+50));
        orders.setFlight_time(flight.getFlight_time());
        orders.setUid(users.getUid());
        orders.setFlight_date(date);
        orders.setFlight_id(flight_id);
        orders.setFlight_number(flight.getFlight_number());
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("flight_id",flight_id);
        params.put("nowdate",date);
        List<People> peopleList = peopleService.getPeopleList(users.getUid());
        model.addAttribute("orders",orders);
        model.addAttribute("peopleList",peopleList);
        return "/aviation/orderinfo";
    }

    @RequestMapping("/submitorder")
    public String SubmitOrder(HttpServletRequest request,Orders orders,Model model){
        HttpSession session = request.getSession();
        Users users = (Users)session.getAttribute("user");
        List<Orders> ordersList = new ArrayList<>();
        orders.setUid(users.getUid());
        ordersList.add(orders);
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("flight_id",orders.getFlight_id());
        params.put("flight_date",orders.getFlight_date());
        List<Seat> seatList = seatService.getSeatList(params);
        Random random = new Random();
        int i = random.nextInt(seatList.size());
        orders.setSeat_number(seatList.get(i).getSeat_number());
        int flag = ordersService.addOrders(ordersList);
        if (flag > 0){
            return "redirect:/getorderlist";
        }
        model.addAttribute("error","添加失败");
        return "/aviation/orderinfo";
    }

    @RequestMapping("/getorderlist")
    public String GetOrderList(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Users users = (Users)session.getAttribute("user");
        Map<String,Object> params = new HashMap<String,Object>();
        if(users.getRole().equals("2")){
            params.put("normal_uid",users.getUid());
            params.put("company_name","");
            params.put("admin_user","");
            List<Orders> ordersList = ordersService.getOrderList(params);
            model.addAttribute("ordersList",ordersList);
            return "/aviation/orderlist";
        }
        if (users.getRole().equals("1")){
            params.put("type","1");
            params.put("uid",users.getUid());
            Company company = companyService.getCompanyInfo(params);
            params.put("normal_uid","");
            params.put("company_name",company.getCompany_name());
            params.put("admin_user","");
            List<Orders> ordersList = ordersService.getOrderList(params);
            model.addAttribute("ordersList",ordersList);
            return "/aviation/orderlist";

        }
        if(users.getRole().equals("0")){
            params.put("normal_uid","");
            params.put("company_name","");
            params.put("admin_uid",users.getUid());
            List<Orders> ordersList = ordersService.getOrderList(params);
            model.addAttribute("ordersList",ordersList);
            return "/aviation/orderlist";
        }
        return "/aviation/404";
    }


    @RequestMapping("/delorder")
    @ResponseBody
    public Msg DelOrder(@RequestParam("order_id")String order_id){
        int flag = ordersService.deleteOrders(Integer.parseInt(order_id));
        if (flag > 0){
            return Msg.success("成功");
        }
        return Msg.fail("失败");
    }
    @RequestMapping("/alipay")
    public void GoPay(HttpServletRequest request, HttpServletResponse response){

        int order_id = Integer.parseInt(request.getParameter("order_id"));
        Orders orders = ordersService.getOrder(order_id);


        //获取初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        String out_trade_no = String.valueOf(order_id);

        //付款金额，必填
        String total_amount = String.valueOf(orders.getOrder_price());

        //订单名称，必填
        String subject = "飞机票";

        //商品描述，可空
        String body = "";

        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "15m";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        try{
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            if (result != null){
                response.setContentType("text/html;charset=" + AlipayConfig.charset);
                response.getWriter().write(result);//直接将完整的表单html输出到页面
                response.getWriter().flush();
                response.getWriter().close();
            }
        }catch (Exception e){
            System.out.println("订单请求错误");
        }

    }

    @RequestMapping("/aliRefund")
    public String aliRefund(HttpServletResponse response, HttpServletRequest request){
        String order_id = request.getParameter("order_id");
        Orders orders = ordersService.getOrder(Integer.parseInt(order_id));
        try {
            //获得初始化的AlipayClient
            //URL APPID RSA_PRIVATE_KEY JSON CHARSET ALIPAY_PUBLIC_KEY  SIGNTYPE
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
            //设置请求参数
            AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
            //商户订单号，商户网站订单系统中唯一订单号
            String out_trade_no = order_id;

            //需要退款的金额，该金额不能大于订单金额，必填
            String refund_amount = orders.getOrder_price();
            //退款的原因说明
            String refund_reason = "退款";

            //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
            Date date = new Date();
            String out_request_no = Long.toString(date.getTime());
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                    + "\"trade_no\":\"\","
                    + "\"refund_amount\":\""+ refund_amount +"\","
                    + "\"refund_reason\":\""+ refund_reason +"\","
                    + "\"out_request_no\":\""+ out_request_no +"\"}");

            //请求
            AlipayTradeRefundResponse result = alipayClient.execute(alipayRequest);
            if(result.isSuccess()){
                ordersService.updateStatus(orders.getOrder_id(),2);
                return "redirect:/getorderlist";
            }
            return "/aviation/404";
        }catch (Exception e){
            e.printStackTrace();
            return "/aviation/404";
        }
    }

    @GetMapping("/return_url")
    public String return_url(HttpServletRequest request) throws Exception{
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();

        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";

            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            System.out.println("同步验签---- " + valueStr);
            params.put(name, valueStr);
        }

        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
            Orders orders = new Orders();
            if(signVerified) {
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

                int flag_order = ordersService.updateStatus(Integer.parseInt(out_trade_no),1);
                if (flag_order > 0 ){
                    return "/aviation/success";
                }
                return "/aviation/fail";
            }else {
                System.out.println("验签失败");
                return "/aviation/fail";
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("验证错误");
            return "/aviation/fail";
        }
    }

    @GetMapping("/notify_url")
    public String notify_url(HttpServletRequest request) throws Exception{
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();

        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";

            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            System.out.println("同步验签---- " + valueStr);
            params.put(name, valueStr);
        }

        try {
            boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
            if(signVerified) {
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

                //付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

                int flag_order = ordersService.updateStatus(Integer.parseInt(out_trade_no),1);
                if (flag_order > 0 ){
                    return "/aviation/success";
                }
                return "/aviation/fail";
            }else {
                System.out.println("验签失败");
                return "/aviation/fail";
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("验证错误");
            return "/aviation/fail";
        }
    }

}
