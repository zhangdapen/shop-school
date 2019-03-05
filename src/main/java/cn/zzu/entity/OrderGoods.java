package cn.zzu.entity;

import java.util.Date;

public class OrderGoods {
    private Integer orderGoodsId;

    private Integer orderId;

    private Integer goodsId;

    private Date createTime;

    private Date updateTime;

    public OrderGoods(Integer orderGoodsId, Integer orderId, Integer goodsId, Date createTime, Date updateTime) {
        this.orderGoodsId = orderGoodsId;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderGoods() {
        super();
    }

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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