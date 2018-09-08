package com.lg.warehouse.dao;

import com.lg.warehouse.entity.Goods;

import java.util.List;

/**
 * @author lin
 * @ClassName GoodsDAO
 * @Description
 * @DATE 2018/9/5 8:57
 **/
public interface GoodsDAO {
    Goods queryGoodsByGoodsID(String goodsID);

    int addGoodsType(Goods goods);

    List<Goods> queryAllGoods();
}
