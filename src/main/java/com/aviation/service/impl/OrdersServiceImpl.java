package com.aviation.service.impl;

import com.aviation.entity.Orders;
import com.aviation.mapper.OrdersMapper;
import com.aviation.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired(required = false)
    private OrdersMapper ordersMapper;

    @Override
    public int addOrders(Orders orders) {
        return ordersMapper.addOrders(orders);
    }

    @Override
    public List<Orders> getOrderList() {
        return ordersMapper.getOrderList();
    }

    @Override
    public Orders getOrder(String order_no) {
        return ordersMapper.getOrder(order_no);
    }

    @Override
    public int deleteOrders(int order_id) {
        return ordersMapper.deleteOrders(order_id);
    }

    @Override
    public int updateStatus(int order_id) {
        return ordersMapper.updateStatus(order_id);
    }
}
