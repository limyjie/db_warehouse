package com.lg.warehouse.dao;

import com.lg.warehouse.entity.Warehouse;

/**
 * @author lin
 * @ClassName WarehouseDAO
 * @Description
 * @DATE 2018/9/5 9:29
 **/
public interface WarehouseDAO {
    Warehouse queryWarehouseByID(String ID);
}
