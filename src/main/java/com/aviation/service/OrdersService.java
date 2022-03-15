package com.aviation.service;

import com.aviation.entity.Orders;

import java.util.List;

public interface OrdersService {
    int addOrders(Orders orders);
    List<Orders> getOrderList();
    Orders getOrder(String order_no);
    int deleteOrders(int order_id);
    int updateStatus(int order_id);

}
