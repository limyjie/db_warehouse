package com.lg.warehouse.service.impl;

import com.lg.warehouse.dao.OrderDAO;
import com.lg.warehouse.dao.WareGoodsDAO;
import com.lg.warehouse.dao.WarehouseDAO;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Order;
import com.lg.warehouse.entity.WareGoods;
import com.lg.warehouse.entity.Warehouse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WarehouseServiceImplTest {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private WarehouseDAO warehouseDAO;

    @Autowired
    private WareGoodsDAO wareGoodsDAO;

    @Test
    public void inputGoods() {
        String orderID = "1007";

        //检查订单是否存在
        System.out.println(orderID);
        Order order = orderDAO.queryOrderByOrderID(orderID);
        if(order==null){
            System.out.println("真的找不到");
            System.out.println("订单不存在");
        }


        //检查仓库是否存在
        Warehouse warehouse =warehouseDAO.queryWarehouseByID(order.getToStorageID());
        if(warehouse==null){
            System.out.println("仓库不存在");
        }

        //检查是否为入库订单
        if(!order.getDirection().equals("In")){
            System.out.println("该订单不是入库订单");
        }
        //检查是否未完成
        if(!order.getExecuted().equals("F")){
            System.out.println("重复操作，该订单已完成入库");
        }

        int num = Integer.valueOf(order.getGoodsNum());
        int remain = warehouse.getRemain();

        if(remain<num){
            System.out.println("仓库剩余容量不足");
        }

        WareGoods wareGoods = new WareGoods();
        wareGoods.setGoodsID(order.getGoodsID());
        wareGoods.setGoodsNum(order.getGoodsNum());
        wareGoods.setWarehouseID(order.getToStorageID());

        //库房中已有该类型货物，则执行update操作
        wareGoodsDAO.queryGoodsInWarehouse(wareGoods);



        //库房中未有该类型货物，则执行insert操作
        if(wareGoods==null){
            wareGoodsDAO.addGoodsToWarehouse(wareGoods);
        }else{
            wareGoodsDAO.modifyGoodsNum(wareGoods);
        }


        warehouse.setRemain(remain-num);
        //修改仓库剩余容量
        warehouseDAO.modifyRemainBySelf(warehouse);
        //修改订单是否已执行
        order.setExecuted("T");
        orderDAO.modifyExecutedBySelf(order);


        System.out.println("订单入库成功");

        return;

    }
}