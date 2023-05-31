package com.javapandeng.po;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private Integer id;
    private Integer itemId;
    private Item item;
    private Integer orderId;
    private Integer status;
    private Integer num;
    private String total;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", item=" + item +
                ", orderId=" + orderId +
                ", status=" + status +
                ", num=" + num +
                ", total='" + total + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public OrderDetail(Integer id, Integer itemId, Item item, Integer orderId, Integer status, Integer num, String total) {
        this.id = id;
        this.itemId = itemId;
        this.item = item;
        this.orderId = orderId;
        this.status = status;
        this.num = num;
        this.total = total;
    }

    public OrderDetail() {
    }
}
