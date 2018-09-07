package com.lg.warehouse.service.impl;

import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Order;
import com.lg.warehouse.service.WarehouseService;
import org.springframework.stereotype.Service;

/**
 * @author lin
 * @ClassName WarehouseServiceImpl
 * @date 2018/9/5 16:24
 * @description
 **/

@Service
public class WarehouseServiceImpl implements WarehouseService {

    //将订单执行入库 实际入库
    //提供  order id，warehouse id ,employee account
    @Override
    public ResponseDTO<Order> inputOrder(String orderID,String warehouseID) {



        return null;
    }

    @Override
    public ResponseDTO<Order> queryFinishedOrder() {
        return null;
    }
}
