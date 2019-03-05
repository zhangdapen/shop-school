package cn.zzu.dao;

import cn.zzu.entity.UserCart;

public interface UserCartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(UserCart record);

    int insertSelective(UserCart record);

    UserCart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(UserCart record);

    int updateByPrimaryKey(UserCart record);
}