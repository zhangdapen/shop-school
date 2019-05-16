package cn.zzu.dao;

import cn.zzu.entity.PermissionInfo;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface PermissionInfoDao {





    void insert(PermissionInfo permissionInfo);

    void update(PermissionInfo permissionInfo);

    PermissionInfo getPermissionInfoById(Long id);

    Integer countPermissionInfo(Map<String, Object> params);

    List<PermissionInfo> getPermissionInfoList(Map<String, Object> params);
}