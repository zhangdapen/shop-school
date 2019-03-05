package cn.zzu.entity;

import java.util.Date;

public class News {
    private Integer newsId;

    private String newsDes;

    private Integer userId;

    private Integer newsState;

    private Integer newsRead;

    private Date createTime;

    private Date updateTime;

    public News(Integer newsId, String newsDes, Integer userId, Integer newsState, Integer newsRead, Date createTime, Date updateTime) {
        this.newsId = newsId;
        this.newsDes = newsDes;
        this.userId = userId;
        this.newsState = newsState;
        this.newsRead = newsRead;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public News() {
        super();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsDes() {
        return newsDes;
    }

    public void setNewsDes(String newsDes) {
        this.newsDes = newsDes == null ? null : newsDes.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNewsState() {
        return newsState;
    }

    public void setNewsState(Integer newsState) {
        this.newsState = newsState;
    }

    public Integer getNewsRead() {
        return newsRead;
    }

    public void setNewsRead(Integer newsRead) {
        this.newsRead = newsRead;
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