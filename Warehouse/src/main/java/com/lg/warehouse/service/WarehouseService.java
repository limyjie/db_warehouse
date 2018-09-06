package com.lg.warehouse.service;

import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Order;

/**
 * @author lin
 * @ClassName WarehouseService
 * @Description
 * @DATE 2018/9/5 16:12
 **/
public interface WarehouseService {

    //实际入库
    ResponseDTO<Order> inputOrder(String orderID,String warehouseID);

    //查询本仓库内的所有货物
    ResponseDTO<Order> queryFinishedOrder();

}
