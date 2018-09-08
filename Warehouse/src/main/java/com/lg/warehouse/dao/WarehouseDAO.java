package com.lg.warehouse.dao;

import com.lg.warehouse.entity.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lin
 * @ClassName WarehouseDAO
 * @Description
 * @DATE 2018/9/5 9:29
 **/
public interface WarehouseDAO {

    Warehouse queryWarehouseByID(String ID);

    //修改仓库剩余容量
    int modifyRemainBySelf(Warehouse self);

    int addWarehoue(Warehouse warehouse);

    List<Warehouse> queryAllWarehouse();
}
