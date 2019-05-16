package cn.zzu.entity;

import java.util.Date;

public class PermissionInfo {
    private Long id;

    private Integer applicaId;

    private Integer applicaType;

    private String applicaDes;

    private Integer applicaState;

    private Integer applicaUid;

    private Date createTime;

    private Date updateTime;

    public PermissionInfo(Long id, Integer applicaId, Integer applicaType, String applicaDes, Integer applicaState, Date createTime, Date updateTime) {
        this.id = id;
        this.applicaId = applicaId;
        this.applicaType = applicaType;
        this.applicaDes = applicaDes;
        this.applicaState = applicaState;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PermissionInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getApplicaId() {
        return applicaId;
    }

    public void setApplicaId(Integer applicaId) {
        this.applicaId = applicaId;
    }

    public Integer getApplicaType() {
        return applicaType;
    }

    public void setApplicaType(Integer applicaType) {
        this.applicaType = applicaType;
    }

    public String getApplicaDes() {
        return applicaDes;
    }

    public void setApplicaDes(String applicaDes) {
        this.applicaDes = applicaDes == null ? null : applicaDes.trim();
    }

    public Integer getApplicaState() {
        return applicaState;
    }

    public void setApplicaState(Integer applicaState) {
        this.applicaState = applicaState;
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

    public Integer getApplicaUid() {
        return applicaUid;
    }

    public void setApplicaUid(Integer applicaUid) {
        this.applicaUid = applicaUid;
    }
}