package cn.zzu.dao;

import cn.zzu.entity.News;

import java.util.List;

public interface NewDao {

    /**
     * 根据用户id获取用户发布的帖子
     * @param userId
     * @return
     */
    List<News> getNewsByUserId(Integer userId);

    /**
     * 获取所有帖子
     * @return
     */
    List<News> getNews();
}