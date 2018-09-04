package com.lg.warehouse.service.impl;

import com.lg.warehouse.dao.OrderDAO;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Order;
import com.lg.warehouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lin
 * @ClassName OrderServiceImpl
 * @date 2018/9/3 19:44
 * @description
 **/

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public ResponseDTO<Order> addOrder(Order order) {

        int result = orderDAO.addOrder(order);

        System.out.println(result);


        return new ResponseDTO<>(0,"success",null);
    }
}
