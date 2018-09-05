package com.lg.warehouse.entity;

import java.sql.Timestamp;

/**
 * @author lin
 * @ClassName Order
 * @date 2018/9/3 19:10
 * @description Builder模式
 **/
public class Order {

    //必要参数
    private String operator;
    private String goodsID;
    private String goodsNum;
    //可选参数
    private String totalValue;
    private String fromStorageID;
    private String toStorageID;
    private String location;
    private String direction;
    private String executed;
    private Timestamp createTime;
    private Timestamp lastModifyTime;

    @Override
    public String toString() {
        return "Order{" +
                "operator='" + operator + '\'' +
                ", goodsID='" + goodsID + '\'' +
                ", goodsNum='" + goodsNum + '\'' +
                ", totalValue='" + totalValue + '\'' +
                ", fromStorageID='" + fromStorageID + '\'' +
                ", toStorageID='" + toStorageID + '\'' +
                ", location='" + location + '\'' +
                ", direction='" + direction + '\'' +
                ", executed='" + executed + '\'' +
                ", createTime='" + createTime + '\'' +
                ", lastModifyTime='" + lastModifyTime + '\'' +
                '}';
    }


    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public void setFromStorageID(String fromStorageID) {
        this.fromStorageID = fromStorageID;
    }

    public void setToStorageID(String toStorageID) {
        this.toStorageID = toStorageID;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setExecuted(String executed) {
        this.executed = executed;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public void setLastModifyTime(Timestamp lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getOperator() {
        return operator;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public String getFromStorageID() {
        return fromStorageID;
    }

    public String getToStorageID() {
        return toStorageID;
    }

    public String getLocation() {
        return location;
    }

    public String getDirection() {
        return direction;
    }

    public String getExecuted() {
        return executed;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Timestamp getLastModifyTime() {
        return lastModifyTime;
    }

    private Order(Builder builder){

        this.operator = builder.operator;
        this.goodsID = builder.goodsID;
        this.goodsNum = builder.goodsNum;
        this.createTime = builder.createTime;
        this.executed = builder.executed;
        this.direction  =builder.direction;
        this.location = builder.location;
        this.toStorageID =builder.toStorageID;
        this.fromStorageID = builder.fromStorageID;
        this.lastModifyTime =builder.lastModifyTime;
        this.createTime = builder.createTime;
        this.totalValue = builder.totalValue;

    }

    public static class Builder{

        private String operator;
        private String goodsID;
        private String goodsNum;
        private String totalValue;
        private String fromStorageID;
        private String toStorageID;
        private String location;
        private String direction;
        private String executed;
        private Timestamp createTime;
        private Timestamp lastModifyTime;

        public Builder(String operatorAccount,String goodsID,String goodsNum){
            this.operator = operatorAccount;
            this.goodsID = goodsID;
            this.goodsNum = goodsNum;
        }

        public Builder totalValue(String totalValue){
            this.totalValue = totalValue;
            System.out.println("total value:"+totalValue);
            return this;
        }

        public Builder fromStorageID(String storageID){
            this.fromStorageID = storageID;
            return this;
        }

        public Builder location(String location){
            this.location = location;
            return this;
        }

        public Builder direction(String direction){
            this.direction = direction;
            return this;
        }
        public Builder executed(String executed){
            this.executed = executed;
            return this;
        }
        public Builder createTime(Timestamp createTime){
            this.createTime = createTime;
            return this;
        }
        public Builder lastModifyTime(Timestamp lastModifyTime){
            this.lastModifyTime = lastModifyTime;
            return this;
        }
        public Builder toStorageID(String storageID){
            this.toStorageID = storageID;
            return this;
        }

        public Order build(){
            return new Order(this);
        }

    }
}
