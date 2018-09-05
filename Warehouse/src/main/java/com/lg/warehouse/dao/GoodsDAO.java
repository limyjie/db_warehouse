package com.lg.warehouse.dao;

import com.lg.warehouse.entity.Goods;

/**
 * @author lin
 * @ClassName GoodsDAO
 * @Description
 * @DATE 2018/9/5 8:57
 **/
public interface GoodsDAO {
    Goods queryGoodsByGoodsID(String goodsID);
}
