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

    @Override
    public String toString() {
        return "Warehouse{" +
                "UID=" + UID +
                ", warehouseID='" + warehouseID + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", location='" + location + '\'' +
                ", remain=" + remain +
                ", capacity=" + capacity +
                '}';
    }

    public Warehouse() {
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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
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
