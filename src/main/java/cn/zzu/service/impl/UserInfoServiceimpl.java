package cn.zzu.service.impl;

import cn.zzu.dao.UserInfoDao;
import cn.zzu.entity.UserInfo;
import cn.zzu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int setInsertUserInfo(UserInfo userInfo) {
        return userInfoDao.insertUserInfo(userInfo);
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
}
