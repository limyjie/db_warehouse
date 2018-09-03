package com.lg.warehouse.service.impl;

import com.lg.warehouse.dao.OrderDAO;
import com.lg.warehouse.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {


    @Autowired
    private OrderDAO orderDAO;

    @Test
    public void addOrder() {

        Timestamp  createDate = new Timestamp(1999-1900,8,4,12,43,34,0);
        Timestamp modifyDate = new Timestamp(2000-1900,2,3,23,1,2,2);

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