package cn.zzu.service;

import cn.zzu.entity.News;

import java.util.List;

public interface NewService {

    /**
     * 根据用户id查询发布的帖子
     * @param userId
     * @return
     */
    List<News> getNewsByUserId(Integer userId);
}
