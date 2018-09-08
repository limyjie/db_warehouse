package com.lg.warehouse.service.impl;

import com.lg.warehouse.dao.GoodsDAO;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Goods;
import com.lg.warehouse.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lin
 * @ClassName GoodsServiceImpl
 * @date 2018/9/7 10:17
 * @description
 **/

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsDAO goodsDAO;

    @Override
    public ResponseDTO<Goods> addGoodsType(Goods goods) {

        System.out.println("impl"+goods.toString());
        int flag = goodsDAO.addGoodsType(goods);

        if(flag!=1){
            return new ResponseDTO<>(707,"货物类型添加失败",null);
        }
        return new ResponseDTO<>(707,"货物类型添加成功",null);

    }

    @Override
    public ResponseDTO<List<Goods>> getAllGoods() {

        List<Goods> goodsList = goodsDAO.queryAllGoods();

        return new ResponseDTO<>(0,"查询所有货物种类成功",goodsList);
    }
}
