package cn.zzu.service.manager;


import ch.qos.logback.classic.Logger;
import cn.zzu.constant.ManagerConstant;
import cn.zzu.dao.UserInfoDao;
import cn.zzu.entity.UserInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Primary
@Service
public class UserPermissionHandler extends AbsPermissionHandler{
    @Autowired
    private PermissionHandlerFactory handlerFactory;
    @Autowired
    private UserInfoDao userInfoDao;
    Logger logger = (Logger) LoggerFactory.getLogger(UserPermissionHandler.class);

    @PostConstruct
    public void postConstruct() {
        handlerFactory.register(ManagerConstant.APPLICA_TYPE_ROOT_SCHOOL, this);
    }
    public void afterCheck(Integer applicaId, Integer applicaState) {
        logger.info("user checkPermissionByApplicaId");
        UserInfo userInfo = userInfoDao.getUserInfoByUserId(applicaId);
        userInfo.setUserState(1);
        userInfoDao.updateUserInfo(userInfo);

    }

}
