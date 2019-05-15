package cn.zzu.service;

import cn.zzu.entity.News;

import java.util.List;
import java.util.Map;

public interface NewService {

    /**
     * 根据用户id查询发布的帖子
     * @param userId
     * @return
     */
    List<News> getNewsByUserId(Integer userId);


    /**
     * 获取所有帖子
     * @return
     */
    Map<String,Object> getNews();
}
