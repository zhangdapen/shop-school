package cn.zzu.service;

import cn.zzu.entity.PermissionInfo;
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
    int insertUserInfo(UserInfo userInfo);


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

    /**
     * 用户申请权限service层接口
     * @param permissionInfo
     * @return
     */
    int setInsertPermissionInfo(PermissionInfo permissionInfo);


    /**
     * 根据题目的问题忘记密码操作
     *
     * @return
     */
    int findPassword(String userName,String userPassword);
    /**
     * 根据名字查找信息
     * @param userName
     * @return
     */
    UserInfo getUserInfoByUserName(String userName);


}
