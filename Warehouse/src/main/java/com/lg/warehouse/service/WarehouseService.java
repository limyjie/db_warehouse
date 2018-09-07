package com.lg.warehouse.service;

import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Goods;
import com.lg.warehouse.entity.Order;
import com.lg.warehouse.entity.WareGoods;

import java.util.List;

/**
 * @author lin
 * @ClassName WarehouseService
 * @Description
 * @DATE 2018/9/5 16:12
 **/
public interface WarehouseService {



    //查询某仓库内的所有货物
    ResponseDTO<List<WareGoods>> queryFinishedOrder(String warehouseID);

    //根据已有的订单执行实际入库操作
    ResponseDTO<WareGoods> inputGoods(String orderID);

    //根据已有的出库订单执行出库操作
    ResponseDTO<WareGoods> outputGoods(String orderID);

}
