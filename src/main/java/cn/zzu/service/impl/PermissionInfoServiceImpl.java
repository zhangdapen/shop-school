package cn.zzu.service.impl;

import cn.zzu.dao.PermissionInfoDao;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.service.PermissionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 权限类service实现
 *
 * @author silence
 * @create 2019-04-22-17:27
 */
@Service
public class PermissionInfoServiceImpl implements PermissionInfoService {

    @Autowired
    private PermissionInfoDao permissionInfoDao;

    @Override
    public int toRootUser(PermissionInfo permissionInfo) {
        return permissionInfoDao.insertPermissionInfo(permissionInfo);
    }
}
