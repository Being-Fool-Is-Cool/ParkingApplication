package com.amrita.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Parking {
    @Id
    @GeneratedValue
    private Long id;

    private String vechicleNumber;

    private String color;

    private Integer level;

    private String sizeOfCar;

    private boolean status;

    @Column(name = "created_at", insertable = true, nullable = false, updatable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date allocatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVechicleNumber() {
        return vechicleNumber;
    }

    public void setVechicleNumber(String vechicleNumber) {
        this.vechicleNumber = vechicleNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getSizeOfCar() {
        return sizeOfCar;
    }

    public void setSizeOfCar(String sizeOfCar) {
        this.sizeOfCar = sizeOfCar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getAllocatedAt() {
        return allocatedAt;
    }

    public void setAllocatedAt(Date allocatedAt) {
        this.allocatedAt = allocatedAt;
    }

    @Override public String toString() {
        return "Parking{" + "id=" + id + ", vechicleNumber='" + vechicleNumber + '\'' + ", color='"
            + color + '\'' + ", level=" + level + ", sizeOfCar='" + sizeOfCar + '\'' + ", status=" + status
            + ", allocatedAt=" + '}';
    }
}
