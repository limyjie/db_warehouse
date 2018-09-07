package com.lg.warehouse.service.impl;

import com.lg.warehouse.dao.GoodsDAO;
import com.lg.warehouse.dao.OrderDAO;
import com.lg.warehouse.dao.WarehouseDAO;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Employee;
import com.lg.warehouse.entity.Goods;
import com.lg.warehouse.entity.Order;
import com.lg.warehouse.entity.Warehouse;
import com.lg.warehouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author lin
 * @ClassName OrderServiceImpl
 * @date 2018/9/3 19:44
 * @description
 **/

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private GoodsDAO goodsDAO;

    @Autowired
    private WarehouseDAO warehouseDAO;

    /**
     * @Description 采购入库
     *     检查货物号是否正确，
     *     货物数量不能为负，
     *     总金额=数量×货物号内的单价，
     *     入库订单需要是未处理
     *     到货仓库号是否存在，
     *     位置是否存在且未被占用，
     *     能否容纳下，
     *     方向是否为入库
     * @Param [order]
     * @return com.lg.warehouse.dto.ResponseDTO<com.lg.warehouse.entity.Order>
     **/
    @Override
    public ResponseDTO<Order> addOrder(Order order, Employee employee) {

        order.setOperator(employee.getAccount());
        order.setCreateTime(new Timestamp(System.currentTimeMillis()));
        order.setExecuted("F");
        order.setLastModifyTime(new Timestamp(System.currentTimeMillis()));
        order.setDirection("In");

        ResponseDTO<Order> responseDTO;

        if(Long.valueOf(order.getGoodsNum())<=0){
            return  new ResponseDTO<>(401,"货物数量不能小于等于零",null);
        }


        Goods getGoods = goodsDAO.queryGoodsByGoodsID(order.getGoodsID());

        if(getGoods==null){
            return  new ResponseDTO<>(401,"该货物号不存在",null);
        }

        Warehouse getWarehouse = warehouseDAO.queryWarehouseByID(order.getToStorageID());

        if(getWarehouse==null){
            return new ResponseDTO<>(401,"仓库号不存在",null);
        }


        long num = Long.valueOf(order.getGoodsNum());
        double value = Double.valueOf(getGoods.getPrice());
        double total = num*value;
        System.out.println("total price is "+ total);

        order.setTotalValue(String.valueOf(total));



        System.out.println("getGoods"+getGoods.toString());



        int result = orderDAO.addOrder(order);

        System.out.println(result);


        return new ResponseDTO<>(0,"success",null);
    }

    @Override
    public ResponseDTO<List<Order>> queryOrders() {

        List<Order> orders = orderDAO.queryAllOrders();

        if(orders==null){
            return new ResponseDTO<>(303,"orders null",null);
        }

        for(Order order:orders){
            System.out.println(order.toString());
        }


        return new ResponseDTO<>(0,"orders success",orders);
    }

    @Override
    public ResponseDTO<List<Order>> queryUnfinishedOrders() {
        List<Order> orders = orderDAO.queryUnfinishedOrders();

        if(orders==null){
            return new ResponseDTO<>(303,"unfinished orders null",null);
        }


        return new ResponseDTO<>(0,"unfinished orders success",orders);
    }

    @Override
    public ResponseDTO<List<Order>> queryFinishOrders() {
        List<Order> orders = orderDAO.queryFinishedOrders();

        if(orders==null){
            return new ResponseDTO<>(303,"finished orders null",null);
        }


        return new ResponseDTO<>(0,"finished orders success",orders);
    }




}
