package cn.zzu.entity;

import java.util.Date;

public class Category {
    private Integer categoryId;

    private String categoryName;

    private String categoryLevel;

    private Integer paremtId;

    private Date createTime;

    private Date updateTime;

    public Category(Integer categoryId, String categoryName, String categoryLevel, Integer paremtId, Date createTime, Date updateTime) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryLevel = categoryLevel;
        this.paremtId = paremtId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Category() {
        super();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(String categoryLevel) {
        this.categoryLevel = categoryLevel == null ? null : categoryLevel.trim();
    }

    public Integer getParemtId() {
        return paremtId;
    }

    public void setParemtId(Integer paremtId) {
        this.paremtId = paremtId;
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