package com.aviation.service.impl;

import com.aviation.entity.Orders;
import com.aviation.mapper.OrdersMapper;
import com.aviation.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired(required = false)
    private OrdersMapper ordersMapper;

    @Override
    public int addOrders(List<Orders> ordersList) {
        return ordersMapper.addOrders(ordersList);
    }

    @Override
    public List<Orders> getOrderList(Map<String,Object> params) {
        return ordersMapper.getOrderList(params);
    }

    @Override
    public Orders getOrder(int order_id) {
        return ordersMapper.getOrder(order_id);
    }

    @Override
    public int deleteOrders(int order_id) {
        return ordersMapper.deleteOrders(order_id);
    }

    @Override
    public int updateStatus(int order_id,int type) {
        return ordersMapper.updateStatus(order_id,type);
    }
}
