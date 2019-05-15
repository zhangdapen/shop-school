package cn.zzu.entity;

import java.util.Date;

/**
 * 收藏表
 *
 * @author silence
 * @create 2019-05-02-16:00
 */
public class Coll {

    private Integer collId;
    private String collDesc;
    private String collImage;
    private Integer collState;
    private Integer collType;
    private Date createTime;
    private Date updateTime;
    private Integer Id;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCollId() {
        return collId;
    }

    public void setCollId(Integer collId) {
        this.collId = collId;
    }

    public String getCollDesc() {
        return collDesc;
    }

    public void setCollDesc(String collDesc) {
        this.collDesc = collDesc;
    }

    public String getCollImage() {
        return collImage;
    }

    public void setCollImage(String collImage) {
        this.collImage = collImage;
    }

    public Integer getCollState() {
        return collState;
    }

    public void setCollState(Integer collState) {
        this.collState = collState;
    }

    public Integer getCollType() {
        return collType;
    }

    public void setCollType(Integer collType) {
        this.collType = collType;
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
        return "Coll{" +
                "collId=" + collId +
                ", collDesc='" + collDesc + '\'' +
                ", collImage='" + collImage + '\'' +
                ", collState=" + collState +
                ", collType=" + collType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", Id=" + Id +
                '}';
    }
}
