package com.lg.warehouse.entity;

/**
 * @author lin
 * @ClassName WareOrder
 * @date 2018/9/6 9:55
 * @description
 **/


//执行入库时，tb_wareorder表中添加此对象（字段）

public class WareGoods {

    private Integer UID;
    private String warehouseID;
    private String goodsID;
    private String goodsNum;

    public WareGoods() {
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Override
    public String toString() {
        return "WareGoods{" +
                "UID=" + UID +
                ", warehouseID='" + warehouseID + '\'' +
                ", goodsID='" + goodsID + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                '}';
    }

    public WareGoods(Integer UID, String warehouseID, String goodsID, String goodsNum) {
        this.UID = UID;
        this.warehouseID = warehouseID;
        this.goodsID = goodsID;
        this.goodsNum = goodsNum;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getOrderID() {
        return goodsID;
    }

    public void setOrderID(String goodsID) {
        this.goodsID = goodsID;
    }
}
