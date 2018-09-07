package com.lg.warehouse.service.impl;

import com.lg.warehouse.dao.GoodsDAO;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsServiceImplTest {


    @Autowired
    private GoodsDAO goodsDAO;

    @Test
    public void addGoodsType() {

        Goods goods = new Goods("123","newGoods","87");

        int flag = goodsDAO.addGoodsType(goods);

        if(flag!=1){
            System.out.println("失败");
        }
        System.out.println("成功");
    }
}