package cn.zzu.entity;

import java.util.Date;

public class SchoolInfo {
    private Integer schoolId;

    private String schoolName;

    private Integer schoolState;

    private Date createTime;

    private Date updateTime;

    public SchoolInfo(Integer schoolId, String schoolName, Integer schoolState, Date createTime, Date updateTime) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolState = schoolState;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SchoolInfo() {
        super();
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public Integer getSchoolState() {
        return schoolState;
    }

    public void setSchoolState(Integer schoolState) {
        this.schoolState = schoolState;
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