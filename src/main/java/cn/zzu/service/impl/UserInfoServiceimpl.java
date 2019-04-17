package cn.zzu.service.impl;

import cn.zzu.dao.UserInfoDao;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.entity.UserInfo;
import cn.zzu.execption.MyExecption;
import cn.zzu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * UserInfo的service实现类
 *
 * @author silence
 * @create 2019-02-22-13:14
 */
@Service
public class UserInfoServiceimpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 登录service实现类
     *
     * @param userInfo 用户信息类
     * @return
     */
    @Override
    public UserInfo getSelectUserInfo(UserInfo userInfo) {
        return userInfoDao.selectUserInfo(userInfo);
    }

    /**
     * 注册service实现类
     *
     * @param userInfo 用户信息类
     * @return
     */

    @Override
    public int insertUserInfo(UserInfo userInfo) {
        userInfo.setUserDate(new Date());
        userInfo.setCreatedAt(System.currentTimeMillis()/1000L);
        userInfo.setUpdatedAt(0L);
        int result=userInfoDao.insertUserInfo(userInfo);
        return result;
    }


    /**
     * 修改用户信息service实现
     *
     * @param userInfo
     * @return
     */
    @Override
    public int setUpdateUserInfo(UserInfo userInfo) {
        return userInfoDao.updateUserInfo(userInfo);
    }


    /**
     * 查询用户所有信息service实现
     * @param userInfo
     * @return
     */
    @Override
    public UserInfo getSelectUserInfoAll(UserInfo userInfo) {
        return userInfoDao.selectUserInfoAll(userInfo);
    }


    /**
     * 用户申请权限service实现
     * @param permissionInfo
     * @return
     */
    @Override
    public int setInsertPermissionInfo(PermissionInfo permissionInfo) {
        return userInfoDao.insertPermissionInfo(permissionInfo);
    }


    /**
     * 找回密码
     * @param userName
     * @param userPassword
     * @return
     */
    @Override
    public int findPassword(String userName, String userPassword) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setUserPassword(userPassword);
        return userInfoDao.updateUserInfoPassword(userInfo);
    }


    /**
     * 根据用户名查找用户信息
     * @param userName
     * @return
     */
    @Override
    public UserInfo getUserInfoByUserName(String userName) {
        List<UserInfo> list = userInfoDao.getUserInfoByUserName(userName);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

}
