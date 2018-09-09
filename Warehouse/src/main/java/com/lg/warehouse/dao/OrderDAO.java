package com.lg.warehouse.dao;

import com.lg.warehouse.entity.Order;

import java.util.List;

/**
 * @author lin
 * @ClassName Order
 * @Description
 * @DATE 2018/9/3 18:56
 **/
public interface OrderDAO {
    int addOrder(Order order);

    List<Order> queryAllOrders();

    List<Order> queryUnfinishedOrders();

    List<Order> queryFinishedOrders();

    Order queryOrderByOrderID(String orderID);

    int modifyExecutedBySelf(Order self);

    int deleteOrderByID(String orderID);

    int deleteFinishedOrder();

}
