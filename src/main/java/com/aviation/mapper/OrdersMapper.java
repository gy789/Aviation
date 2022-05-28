package com.aviation.mapper;

import com.aviation.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrdersMapper {
    int addOrders(List<Orders> ordersList);
    List<Orders> getOrderList(@Param("params") Map<String,Object> params);
    Orders getOrder(int order_id);
    int deleteOrders(int order_id);
    int updateStatus(@Param("order_id") int order_id,@Param("type") int type);
}
