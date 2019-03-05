package cn.zzu.entity;

import java.util.Date;

public class UserCart {
    private Integer cartId;

    private Integer userId;

    private Integer goodsId;

    private Date createTime;

    private Date updateTime;

    public UserCart(Integer cartId, Integer userId, Integer goodsId, Date createTime, Date updateTime) {
        this.cartId = cartId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserCart() {
        super();
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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