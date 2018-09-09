package com.lg.warehouse.dao;

import com.lg.warehouse.entity.Order;
import com.lg.warehouse.entity.WareGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lin
 * @ClassName WareOrder
 * @Description
 * @DATE 2018/9/6 9:57
 **/
public interface WareGoodsDAO {

    //查询该库房内的所有货物（已完成的货物）
    List<WareGoods> queryGoodsByWarehouseID(String ID);

    //将货物执行入库
    int addGoods(WareGoods wareGoods);

    //修改货物数量
    int modifyGoodsNum(WareGoods wareGoods);

    //将货物执行出库，
    int decreaseGoodsNum(WareGoods wareGoods);

    //查询某仓库内的某货物数量
    WareGoods queryGoodsNum(@Param("warehouseID") String warehouseID,@Param("goodsID") String goodsID);

    //出库时，若仓库中该货物的剩余数量等于出库数量，出库后删除此字段
    int deleteWareGoodsByID(String  goodsID);
}
