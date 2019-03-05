package cn.zzu.entity;

import java.util.Date;

public class OrderInfo {
    private Integer orderId;

    private Double orderAmount;

    private Integer addrId;

    private Integer orderState;

    private Date createTime;

    private Date updateTime;

    public OrderInfo(Integer orderId, Double orderAmount, Integer addrId, Integer orderState, Date createTime, Date updateTime) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.addrId = addrId;
        this.orderState = orderState;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderInfo() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}