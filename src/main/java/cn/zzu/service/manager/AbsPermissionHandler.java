package cn.zzu.service.manager;

import ch.qos.logback.classic.Logger;
import cn.zzu.controller.SysManager.PermissionController;
import cn.zzu.dao.PermissionInfoDao;
import cn.zzu.entity.PermissionInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhanghongling on 2019/5/16.
 */
@Service
public class AbsPermissionHandler implements PermissionHandler {
    Logger logger = (Logger) LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private PermissionInfoDao permissionInfoDao;
    @Override
    public void checkPermission(Long id, Integer applicaState) {
        logger.info("checkPermission in 111");
        PermissionInfo permissionInfo = permissionInfoDao.getPermissionInfoById(id);
        permissionInfo.setApplicaState(applicaState);
        permissionInfoDao.update(permissionInfo);

    }

    public void afterCheck(Integer applicaId, Integer applicaState){

    }
}
