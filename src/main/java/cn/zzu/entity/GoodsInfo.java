package cn.zzu.entity;

import java.util.Date;

public class GoodsInfo {
    private Integer goodsId;

    private String goodsName;

    private String goodsDes;

    private String goodsImage;

    private Integer userId;

    private Double goodsPrice;

    private Integer categoryId;

    private Integer schoolId;

    private Integer goodsState;

    private Date createTime;

    private Date updateTime;

    public GoodsInfo(Integer goodsId, String goodsName, String goodsDes, String goodsImage, Integer userId, Double goodsPrice, Integer categoryId, Integer schoolId, Integer goodsState, Date createTime, Date updateTime) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsDes = goodsDes;
        this.goodsImage = goodsImage;
        this.userId = userId;
        this.goodsPrice = goodsPrice;
        this.categoryId = categoryId;
        this.schoolId = schoolId;
        this.goodsState = goodsState;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public GoodsInfo() {
        super();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsDes() {
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes == null ? null : goodsDes.trim();
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
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