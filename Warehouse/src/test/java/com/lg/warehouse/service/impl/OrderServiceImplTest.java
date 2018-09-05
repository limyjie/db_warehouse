package com.lg.warehouse.service.impl;

import com.lg.warehouse.dao.GoodsDAO;
import com.lg.warehouse.dao.OrderDAO;
import com.lg.warehouse.entity.Goods;
import com.lg.warehouse.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.Timestamp;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {


    @Autowired
    private OrderDAO orderDAO;


    @Autowired
    private GoodsDAO goodsDAO;

    @Test
    public void addOrder() {

        Goods getGoods = goodsDAO.queryGoodsByGoodsID("");


        Timestamp  createDate = new Timestamp(System.currentTimeMillis());

        Timestamp modifyDate = new Timestamp(System.currentTimeMillis());

        Order order = new  Order.Builder("root","2000","20")
                .direction("in")
                .executed("F")
                .fromStorageID("666")
                .toStorageID("777")
                .totalValue("888")
                .createTime(createDate)
                .lastModifyTime(modifyDate)
                .location("999").build();

        System.out.println(order.toString());
        int result  = orderDAO.addOrder(order);

        System.out.println(result);
    }
}