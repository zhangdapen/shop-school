package cn.zzu.entity;

import java.util.Date;

public class UserAddr {
    private Integer addrId;

    private Integer userId;

    private String addrDesc;

    private Date createTime;

    private Date updateTime;

    private Integer addrState;


    public UserAddr(Integer addrId, Integer userId, String addrDesc, Date createTime, Date updateTime, Integer addrState) {
        this.addrId = addrId;
        this.userId = userId;
        this.addrDesc = addrDesc;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.addrState = addrState;
    }

    public Integer getAddrState() {
        return addrState;
    }

    public void setAddrState(Integer addrState) {
        this.addrState = addrState;
    }

    public UserAddr() {
        super();
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddrDesc() {
        return addrDesc;
    }

    public void setAddrDesc(String addrDesc) {
        this.addrDesc = addrDesc == null ? null : addrDesc.trim();
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

    @Override
    public String toString() {
        return "UserAddr{" +
                "addrId=" + addrId +
                ", userId=" + userId +
                ", addrDesc='" + addrDesc + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", addrState=" + addrState +
                '}';
    }
}