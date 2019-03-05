package cn.zzu.entity;

import java.util.Date;

public class CommentNews {
    private Integer commentId;

    private Integer newsId;

    private Integer userId;

    private Integer commentState;

    private String commentDesc;

    private Date createTime;

    private Date updateTime;

    public CommentNews(Integer commentId, Integer newsId, Integer userId, Integer commentState, String commentDesc, Date createTime, Date updateTime) {
        this.commentId = commentId;
        this.newsId = newsId;
        this.userId = userId;
        this.commentState = commentState;
        this.commentDesc = commentDesc;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CommentNews() {
        super();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommentState() {
        return commentState;
    }

    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc == null ? null : commentDesc.trim();
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