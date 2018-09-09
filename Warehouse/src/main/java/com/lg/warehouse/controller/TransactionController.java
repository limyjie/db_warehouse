package com.lg.warehouse.controller;




import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.*;
import com.lg.warehouse.service.GoodsService;
import com.lg.warehouse.service.OrderService;
import com.lg.warehouse.service.WarehouseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private GoodsService goodsService;


    @PostMapping(value = "/postOrder")
    public ResponseDTO<Order> postOrder(@RequestBody String params, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){


        System.out.println("//提交新的订单（出库/入库）");
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



    //根据订单ID查询订单
    @PostMapping(value = "queryOrderByID")
    public ResponseDTO<Order> getOrderByID(@RequestBody String params){
        String orderID = params;
        System.out.println("orderID:"+orderID);
        return orderService.queryOrderByID(orderID);
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

    //添加货物种类
    @PostMapping(value = "addGoods")
    public ResponseDTO<Goods> addGoodsType(@RequestBody String params){

        System.out.println(params);
        Goods goods = JSON.parseObject(params,Goods.class);
        System.out.println("controller goods:" + goods);
        return goodsService.addGoodsType(goods);
    }


    //查询所有仓库
    @GetMapping(value = "queryWare")
    public ResponseDTO<List<Warehouse>> queryWarehouse(){


        return warehouseService.queryWarehouse();
    }


    //添加新的仓库
    @PostMapping(value = "addWarehouse")
    public ResponseDTO<Warehouse> addWarehouse(@RequestBody String params){



       Warehouse warehouse = JSON.parseObject(params,Warehouse.class);
       warehouse.setRemain(warehouse.getCapacity());

        System.out.println(warehouse.toString());

        return warehouseService.addWarehouse(warehouse);
    }

    @GetMapping(value = "getAllGoods")
    public ResponseDTO<List<Goods>> getAllGoods(){
        return goodsService.getAllGoods();
    }


    @PostMapping(value = "deleteOrderByID")
    public ResponseDTO<Order> deleteOrder(@RequestBody String params){

        System.out.println(params);
        return orderService.deleteOrder(params);
    }


    @GetMapping(value = "deleteFinishedOrder")
    public ResponseDTO<Order> deleteFinishedOrder(){
        return orderService.deleteFinishedOrder();
    }

    @PostMapping(value = "queryWareGoods")
    public ResponseDTO<List<WareGoods>> queryWareGoods(@RequestBody String params){
        System.out.println(params);

        return warehouseService.queryFinishedOrder(params);
    }
}

