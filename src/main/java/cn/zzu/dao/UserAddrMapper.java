package cn.zzu.dao;

import cn.zzu.entity.UserAddr;

public interface UserAddrMapper {
    int deleteByPrimaryKey(Integer addrId);

    int insert(UserAddr record);

    int insertSelective(UserAddr record);

    UserAddr selectByPrimaryKey(Integer addrId);

    int updateByPrimaryKeySelective(UserAddr record);

    int updateByPrimaryKey(UserAddr record);
}