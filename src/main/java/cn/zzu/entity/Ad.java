package cn.zzu.entity;

import java.util.Date;

public class Ad {
    private Integer adId;

    private String adIamge;

    private Integer adState;

    private Integer userId;

    private Date createTime;

    private Date updateTime;

    public Ad(Integer adId, String adIamge, Integer adState, Integer userId, Date createTime, Date updateTime) {
        this.adId = adId;
        this.adIamge = adIamge;
        this.adState = adState;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Ad() {
        super();
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getAdIamge() {
        return adIamge;
    }

    public void setAdIamge(String adIamge) {
        this.adIamge = adIamge == null ? null : adIamge.trim();
    }

    public Integer getAdState() {
        return adState;
    }

    public void setAdState(Integer adState) {
        this.adState = adState;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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