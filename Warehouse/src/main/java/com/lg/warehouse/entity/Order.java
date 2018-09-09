package com.lg.warehouse.entity;

import java.sql.Timestamp;

/**
 * @author lin
 * @ClassName Order
 * @date 2018/9/3 19:10
 * @description Builder模式
 **/
public class Order {

    private String orderID;
    private String operatorAccount;
    private String goodsID;
    private String goodsNum;
    private String totalValue;
    private String warehouseID;
    private String direction;
    private String executed;
    private Timestamp createTime;
    private Timestamp lastModifyTime;

    public Order() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOperatorAccount() {
        return operatorAccount;
    }

    public void setOperatorAccount(String operatorAccount) {
        this.operatorAccount = operatorAccount;
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

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public String getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(String warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getExecuted() {
        return executed;
    }

    public void setExecuted(String executed) {
        this.executed = executed;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Timestamp lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", operatorAccount='" + operatorAccount + '\'' +
                ", goodsID='" + goodsID + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                ", totalValue='" + totalValue + '\'' +
                ", warehouseID='" + warehouseID + '\'' +
                ", direction='" + direction + '\'' +
                ", executed='" + executed + '\'' +
                ", createTime=" + createTime +
                ", lastModifyTime=" + lastModifyTime +
                '}';
    }

    public Order(String orderID, String operatorAccount, String goodsID, String goodsNum, String totalValue, String warehouseID, String direction, String executed, Timestamp createTime, Timestamp lastModifyTime) {
        this.orderID = orderID;
        this.operatorAccount = operatorAccount;
        this.goodsID = goodsID;
        this.goodsNum = goodsNum;
        this.totalValue = totalValue;
        this.warehouseID = warehouseID;
        this.direction = direction;
        this.executed = executed;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
    }
}
