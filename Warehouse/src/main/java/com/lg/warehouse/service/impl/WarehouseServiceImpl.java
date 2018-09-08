package com.lg.warehouse.service.impl;

import com.lg.warehouse.dao.OrderDAO;
import com.lg.warehouse.dao.WareGoodsDAO;
import com.lg.warehouse.dao.WarehouseDAO;
import com.lg.warehouse.dto.ResponseDTO;
import com.lg.warehouse.entity.Goods;
import com.lg.warehouse.entity.Order;
import com.lg.warehouse.entity.WareGoods;
import com.lg.warehouse.entity.Warehouse;
import com.lg.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lin
 * @ClassName WarehouseServiceImpl
 * @date 2018/9/5 16:24
 * @description
 **/

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private WarehouseDAO warehouseDAO;

    @Autowired
    private WareGoodsDAO wareGoodsDAO;


    //根据库房id查询该库房内的所有货物
    @Override
    public ResponseDTO<List<WareGoods>> queryFinishedOrder(String warehouseID) {

       List<WareGoods> wareGoodsList = wareGoodsDAO.queryGoodsByWarehouseID(warehouseID);

        //不存在该库房
        if(wareGoodsList==null){
            return new ResponseDTO<>(10,"不存在该库房",null);
        }

        for(WareGoods o:wareGoodsList){
            System.out.println(o.toString());
        }
        System.out.println("-----------");
        return new ResponseDTO<>(0,"查询该仓库货物成功",wareGoodsList);
    }

    //根据已有的订单执行入库操作
    //提供  order id，warehouse id
    @Override
    public ResponseDTO<WareGoods> inputGoods(String orderID) {


        //检查订单是否存在
        System.out.println(orderID);
        Order order = orderDAO.queryOrderByOrderID(orderID);
        if(order==null){
            return new ResponseDTO<>(505,"订单不存在",null);
        }


        //检查仓库是否存在
        Warehouse warehouse =warehouseDAO.queryWarehouseByID(order.getToStorageID());
        if(warehouse==null){
            return new ResponseDTO<>(505,"仓库不存在",null);
        }

        //检查是否为入库订单
        if(!order.getDirection().equals("In")){
            return new ResponseDTO<>(505,"该订单不是入库订单",null);
        }
        //检查是否未完成
        if(!order.getExecuted().equals("F")){
            return new ResponseDTO<>(505,"重复操作，该订单已完成入库",null);
        }

        int num = Integer.valueOf(order.getGoodsNum());
        int remain = warehouse.getRemain();

        if(remain<num){
            return new ResponseDTO<>(505,"仓库剩余容量不足",null);
        }

        WareGoods wareGoods = new WareGoods();
        wareGoods.setGoodsID(order.getGoodsID());
        wareGoods.setGoodsNum(order.getGoodsNum());
        wareGoods.setWarehouseID(order.getToStorageID());

        //库房中已有该类型货物，则执行update操作
        wareGoodsDAO.queryGoodsInWarehouse(wareGoods);



        //库房中未有该类型货物，则执行insert操作
        if(wareGoods==null){
            wareGoodsDAO.addGoodsToWarehouse(wareGoods);
        }else{
            wareGoodsDAO.modifyGoodsNum(wareGoods);
        }


        warehouse.setRemain(remain-num);
        //修改仓库剩余容量
        warehouseDAO.modifyRemainBySelf(warehouse);
        //修改订单是否已执行
        order.setExecuted("T");
        orderDAO.modifyExecutedBySelf(order);


        return new ResponseDTO<>(0,"订单已入库",wareGoods);
    }



    @Override
    public ResponseDTO<WareGoods> outputGoods(String orderID) {


        //检查订单是否存在
        Order order = orderDAO.queryOrderByOrderID(orderID);
        if(order==null){
            return new ResponseDTO<>(505,"订单不存在",null);
        }

        //检查是否为出库订单
        if(!order.getDirection().equals("Out")){
            return new ResponseDTO<>(505,"该订单不是出库订单",null);
        }
        //检查是否未完成
        if(!order.getExecuted().equals("F")){
            return new ResponseDTO<>(505,"重复操作，该订单已完成出库",null);
        }

        //检查仓库是否存在
        Warehouse warehouse =warehouseDAO.queryWarehouseByID(order.getFromStorageID());
        if(warehouse==null){
            return new ResponseDTO<>(505,"仓库不存在",null);
        }



        //数量检查
        WareGoods wareGoods = wareGoodsDAO.queryWareGoodsFromWarehouse(order.getFromStorageID(),order.getGoodsID());
        double orderNum = Double.valueOf(order.getGoodsNum());
        double remainNum = Double.valueOf(wareGoods.getGoodsNum());
        if(remainNum<orderNum){
            return new ResponseDTO<>(505,"仓库内剩余货物不足",null);
        }


        //执行出库
        wareGoods.setGoodsNum(String.valueOf(remainNum-orderNum));
        wareGoodsDAO.decreaseGoodsNum(wareGoods);


        return new ResponseDTO<>(0,"出库成功",wareGoods);
    }

    @Override
    public ResponseDTO<Warehouse> addWarehouse(Warehouse warehouse) {
        System.out.println("new warehouse:"+warehouse.toString());


        //添加库房时库房号不允许重复
        if(warehouseDAO.queryWarehouseByID(warehouse.getWarehouseID())!=null){
            return new ResponseDTO<>(0,"该库房号已存在",null);
        }

        int addCompliete = warehouseDAO.addWarehoue(warehouse);
        if(addCompliete!=1){
            return new ResponseDTO<>(0,"库房添加失败",null);
        }

        return new ResponseDTO<>(0,"库房添加成功",warehouse);

    }

    @Override
    public ResponseDTO<List<Warehouse>> queryWarehouse() {

        List<Warehouse> warehouseList = warehouseDAO.queryAllWarehouse();

        for(Warehouse w:warehouseList){
            System.out.println(w.toString());
        }
        return new ResponseDTO<>(0,"查询库房成功",warehouseList);
    }
}
