package cn.zzu.entity;

import java.util.Date;

public class PermissionInfo {
    private Integer permissionId;

    private Integer applicaId;

    private String applicaType;

    private String applicaDes;

    private String applicaState;

    private Date createTime;

    private Date updateTime;

    public PermissionInfo(Integer permissionId, Integer applicaId, String applicaType, String applicaDes, String applicaState, Date createTime, Date updateTime) {
        this.permissionId = permissionId;
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

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getApplicaId() {
        return applicaId;
    }

    public void setApplicaId(Integer applicaId) {
        this.applicaId = applicaId;
    }

    public String getApplicaType() {
        return applicaType;
    }

    public void setApplicaType(String applicaType) {
        this.applicaType = applicaType == null ? null : applicaType.trim();
    }

    public String getApplicaDes() {
        return applicaDes;
    }

    public void setApplicaDes(String applicaDes) {
        this.applicaDes = applicaDes == null ? null : applicaDes.trim();
    }

    public String getApplicaState() {
        return applicaState;
    }

    public void setApplicaState(String applicaState) {
        this.applicaState = applicaState == null ? null : applicaState.trim();
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