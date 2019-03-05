package cn.zzu.dao;

import cn.zzu.entity.PermissionInfo;

public interface PermissionInfoMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(PermissionInfo record);

    int insertSelective(PermissionInfo record);

    PermissionInfo selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(PermissionInfo record);

    int updateByPrimaryKey(PermissionInfo record);
}