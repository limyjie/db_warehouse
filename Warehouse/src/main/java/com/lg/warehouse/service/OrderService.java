package com.lg.warehouse.service;

import com.lg.warehouse.dao.OrderDAO;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Employee;
import com.lg.warehouse.entity.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * @author lin
 * @ClassName OrderService
 * @Description
 * @DATE 2018/9/3 19:43
 **/
public interface OrderService {
    //生成订单（包括入库订单和出库订单）
    ResponseDTO<Order> addOrder(Order order, Employee employee);

    ResponseDTO<List<Order>> queryOrders();

    ResponseDTO<List<Order>> queryUnfinishedOrders();

    ResponseDTO<List<Order>> queryFinishOrders();

    //根据订单id查订单
    ResponseDTO<Order> queryOrderByID(String orderID);

    //根据ID删除订单
    ResponseDTO<Order> deleteOrder(String orderID);

    //删除所有已完成订单
    ResponseDTO<Order> deleteFinishedOrder();
}
