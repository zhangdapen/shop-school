package cn.zzu.service;

import cn.zzu.entity.UserInfo;

public interface UserInfoService {

    /**
     * 登录service接口
     * @param userInfo  用户信息类
     * @return
     */
    UserInfo getSelectUserInfo(UserInfo userInfo);

    /**
     * 注册service接口
     * @param userInfo 用户信息类
     * @return
     */
    int setInsertUserInfo(UserInfo userInfo);


    /**
     * 修改用户信息service接口
     * @param userInfo
     * @return
     */
    int setUpdateUserInfo(UserInfo userInfo);


    /**
     * 查询用户所有信息service接口
     * @param userInfo
     * @return
     */
    UserInfo getSelectUserInfoAll(UserInfo userInfo);

}
