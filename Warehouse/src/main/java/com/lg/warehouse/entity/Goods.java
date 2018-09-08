package com.lg.warehouse.entity;

/**
 * @author lin
 * @ClassName Goods
 * @date 2018/9/5 8:52
 * @description
 **/
public class Goods {
    private Integer UID;
    private String goodsID;
    private String goodsName;

    private String price;//单价

    public Goods() {
    }


    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
