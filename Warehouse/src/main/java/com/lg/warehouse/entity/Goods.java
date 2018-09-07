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

    @Override
    public String toString() {
        return "Goods{" +
                "UID='" + UID + '\'' +
                "goodsID='" + goodsID + '\'' +
                ", goodsName='" + goodsName + '\'' +

                ", price='" + price + '\'' +
                '}';
    }

    public Goods(String goodsID,String goodsName,String price){
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.price =price;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public void setGooodsName(String gooodsName) {
        this.goodsName = gooodsName;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public String getGooodsName() {
        return goodsName;
    }


    public String getPrice() {
        return price;
    }

    public Goods(Integer UID,String goodsID, String goodsName,String price) {
        this.UID = UID;
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.price = price;
    }
}
