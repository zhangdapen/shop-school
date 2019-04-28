package cn.zzu.service;


import cn.zzu.entity.PermissionInfo;

public interface PermissionInfoService {


    /**
     * 申请为管理员
     * @param permissionInfo
     * @return
     */
    int toRootUser(PermissionInfo permissionInfo);
}
