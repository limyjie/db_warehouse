package com.lg.warehouse.controller;

import com.alibaba.fastjson.JSON;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Employee;
import com.lg.warehouse.entity.Goods;
import com.lg.warehouse.entity.Order;
import com.lg.warehouse.entity.WareGoods;
import com.lg.warehouse.service.OrderService;
import com.lg.warehouse.service.WarehouseService;
import org.aspectj.weaver.ast.Or;
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
public class TransactionController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private WarehouseService warehouseService;

    //提交新的订单（出库/入库）
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


    //查询所有未完成订单
    @GetMapping(value = "unfinishedOrders")
    public ResponseDTO<List<Order>> getUnfinishedOrder(){
        return orderService.queryUnfinishedOrders();
    }


    //查询所有已完成订单
    @GetMapping(value = "finishedOrders")
    public ResponseDTO<List<Order>> getFinishedOrder(){
        return orderService.queryFinishOrders();
    }


    //查询所有订单
    @GetMapping(value = "allOrders")
    public ResponseDTO<List<Order>> getOrders(){
        return orderService.queryOrders();
    }


    //查询某一库房内的所有货物
    @PostMapping(value = "warehouseGoods")
    public ResponseDTO<List<WareGoods>> getWarehouseGoods(@RequestBody String params){

        String warehouseID = params;
        System.out.println("controller warehouse id:"+warehouseID);
        return warehouseService.queryFinishedOrder(warehouseID);
    }

    //订单入库
    @PostMapping(value = "inputOrder")
    public ResponseDTO<WareGoods> inputOrder(@RequestBody String params){

        String orderID = params;
        System.out.println("controller orderID id:"+orderID);
        return warehouseService.inputGoods(orderID);
    }

    //订单出库
    @PostMapping(value = "outputOrder")
    public ResponseDTO<WareGoods> outputOrder(@RequestBody String params){

        String orderID = params;
        System.out.println("controller orderID id:"+orderID);
        return warehouseService.outputGoods(orderID);

    }

}

