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
    //多表查询，涉及tb_wareorder 和  tb_order

    List<WareGoods> queryGoodsByWarehouseID(String ID);

    //将货物执行入库
    int addGoodsToWarehouse(WareGoods wareGoods);

    //将货物执行出库，
    int decreaseGoodsNum(WareGoods wareGoods);

    //查询某仓库内的某货物数量
    WareGoods queryWareGoodsFromWarehouse(String warehouseID,String goodsID);

}
