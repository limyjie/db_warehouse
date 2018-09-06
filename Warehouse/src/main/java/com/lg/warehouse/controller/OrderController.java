package com.lg.warehouse.controller;

import com.alibaba.fastjson.JSON;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Employee;
import com.lg.warehouse.entity.Order;
import com.lg.warehouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author lin
 * @ClassName OrderController
 * @date 2018/9/5 9:53
 * @description
 **/

@RestController
@RequestMapping(value = "order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/postOrder")
    public ResponseDTO<Order> postOrder(@RequestBody String params, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        Order order = JSON.parseObject(params,Order.class);



        Employee  operator = (Employee)httpServletRequest.getSession().getAttribute("session_employee_name");

        if(operator==null){
            return new ResponseDTO<>(402,"session 失效",null);
        }


        System.out.println("order to service:" + order.toString());
        return orderService.addOrder(order,operator);


    }


    @GetMapping(value = "unfinishedOrders")
    public ResponseDTO<List<Order>> getUnfinishedOrder(){
        return orderService.queryUnfinishedOrders();
    }


    @GetMapping(value = "finishedOrders")
    public ResponseDTO<List<Order>> getFinishedOrder(){
        return orderService.queryFinishOrders();
    }


    @GetMapping(value = "allOrders")
    public ResponseDTO<List<Order>> getOrders(){
        return orderService.queryOrders();
    }

}
