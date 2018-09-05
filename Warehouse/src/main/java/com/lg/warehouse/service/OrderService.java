package com.lg.warehouse.service;

import com.lg.warehouse.dao.OrderDAO;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Employee;
import com.lg.warehouse.entity.Order;

/**
 * @author lin
 * @ClassName OrderService
 * @Description
 * @DATE 2018/9/3 19:43
 **/
public interface OrderService {
    ResponseDTO<Order> addOrder(Order order, Employee employee);
}
