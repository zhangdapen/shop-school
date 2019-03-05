package cn.zzu.dao;

import cn.zzu.entity.CommentNews;

public interface CommentNewsMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(CommentNews record);

    int insertSelective(CommentNews record);

    CommentNews selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CommentNews record);

    int updateByPrimaryKey(CommentNews record);
}