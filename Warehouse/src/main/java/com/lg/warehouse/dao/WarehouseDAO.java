package com.lg.warehouse.dao;

import com.lg.warehouse.entity.Warehouse;
import org.apache.ibatis.annotations.Param;

/**
 * @author lin
 * @ClassName WarehouseDAO
 * @Description
 * @DATE 2018/9/5 9:29
 **/
public interface WarehouseDAO {

    Warehouse queryWarehouseByID(String ID);
    //将未执行入库的订单执行入库
    int inputOrderToWarehouse(@Param("order_id")String orderID,@Param("id")String warehouseID);
    //将未执行出库的订单出库
    int outputOrderFromWarehouse(@Param("order_id")String orderID,@Param("id")String warehouseID);




}
