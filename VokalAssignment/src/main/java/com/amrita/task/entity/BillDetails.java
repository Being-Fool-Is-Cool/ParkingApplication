package com.amrita.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BillDetails {
    @Id
    @GeneratedValue
    private Long id;
    private int orderId;
    private Long tableNo;
    private String orderName;
    private String itemName;
    private int itemQnt;
    private int orderQnt;
    private String itemCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Long getTableNo() {
        return tableNo;
    }

    public void setTableNo(Long tableNo) {
        this.tableNo = tableNo;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQnt() {
        return itemQnt;
    }

    public void setItemQnt(int itemQnt) {
        this.itemQnt = itemQnt;
    }

    public int getOrderQnt() {
        return orderQnt;
    }

    public void setOrderQnt(int orderQnt) {
        this.orderQnt = orderQnt;
    }

    public String getItemCost() {
        return itemCost;
    }

    public void setItemCost(String itemCost) {
        this.itemCost = itemCost;
    }
}
