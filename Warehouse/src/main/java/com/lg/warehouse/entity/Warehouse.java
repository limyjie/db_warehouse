package com.lg.warehouse.entity;

/**
 * @author lin
 * @ClassName Warehouse
 * @date 2018/9/5 9:26
 * @description
 **/
public class Warehouse {

    private Integer UID;
    private String warehouseID;
    private String warehouseName;
    private String location;
    private Integer remain;
    private Integer capacity;



    public Warehouse(Integer UID, String warehouseID, String warehouseName, String location, Integer remain, Integer capacity) {
        this.UID = UID;
        this.warehouseID = warehouseID;
        this.warehouseName = warehouseName;
        this.location = location;
        this.remain = remain;
        this.capacity = capacity;

    }


    @Override
    public String toString() {
        return "Warehouse{" +
                "UID=" + UID +
                ", ID='" + warehouseID + '\'' +
                ", name='" + warehouseName + '\'' +
                ", location='" + location + '\'' +
                ", remain=" + remain +
                ", capacity=" + capacity +
                '}';
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public String getID() {
        return warehouseID;
    }

    public void setID(String ID) {
        this.warehouseID = ID;
    }

    public String getName() {
        return warehouseName;
    }

    public void setName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


}
