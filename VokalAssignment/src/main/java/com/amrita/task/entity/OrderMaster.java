package com.amrita.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderMaster {
    @Id
    @GeneratedValue
    private Long id;
    private Long tableNo;
    private String date;
    private String time;
//    private enum OrderStatus { JUST_ORDERED, IN_PROCESS, COOKED, DELIVERED }
    private String orderStatus;

    private String orderName ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTableNo() {
        return tableNo;
    }

    public void setTableNo(Long tableNo) {
        this.tableNo = tableNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrderStat() {
        return orderStatus;
    }

    public void setOrderStat(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
