package cn.zzu.service.manager.impl;

import cn.zzu.dao.PermissionInfoDao;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.service.manager.PermissionHandler;
import cn.zzu.service.manager.PermissionHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 权限类service实现
 *
 * @author silence
 * @create 2019-04-22-17:27
 */
@Service
public class PermissionInfoServiceImpl {

    @Autowired
    private PermissionInfoDao permissionInfoDao;
    @Autowired
    private PermissionHandlerFactory permissionHandlerFactory;


    public void insertPermissionInfo(PermissionInfo permissionInfo) {
        permissionInfo.setCreateTime(new Date());
        permissionInfo.setUpdateTime(new Date());
        permissionInfoDao.insert(permissionInfo);
    }

    public List<PermissionInfo> getPermissionInfoList(Map<String,Object> map) {
        return permissionInfoDao.getPermissionInfoList(map);
    }


    public void updatePermissionStatus(Long permissionId,Integer applicaState){
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setId(permissionId);
        permissionInfo.setApplicaState(applicaState);
        permissionInfoDao.update(permissionInfo);
    }

    public void checkPermission(Long permissionId,Integer applicaState){
        PermissionInfo permissionInfo = permissionInfoDao.getPermissionInfoById(permissionId);
        Integer type = permissionInfo.getApplicaType();
        PermissionHandler permissionHandler = permissionHandlerFactory.getTaskHandler(type);
        permissionHandler.checkPermission(permissionId,applicaState);
        permissionHandler.afterCheck(permissionInfo.getApplicaId(),applicaState);
    }



}
