package com.lg.warehouse.service;

import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Goods;

import java.util.List;

/**
 * @author lin
 * @ClassName GoodsService
 * @Description
 * @DATE 2018/9/7 10:16
 **/
public interface GoodsService {

    //添加货物种类
    ResponseDTO<Goods> addGoodsType(Goods goods);

    //查询所有货物种类
    ResponseDTO<List<Goods>> getAllGoods();
}
