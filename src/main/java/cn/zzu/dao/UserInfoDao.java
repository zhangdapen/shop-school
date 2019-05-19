package cn.zzu.dao;


import cn.zzu.entity.PermissionInfo;
import cn.zzu.entity.UserInfo;

import java.util.List;


public interface UserInfoDao {

    /**
     * 登录   dao层接口
     * @param userInfo  用户信息
     * @return UserInfo 用户信息
     */
    UserInfo selectUserInfo(UserInfo userInfo);

    /**
     * 注册   dao层接口
     * @param userInfo  (用户名,密码,学校对象)
     * @return
     */
    int insertUserInfo(UserInfo userInfo);


    /**
     * 修改用户信息  dao层接口
     * @param userInfo  用户信息类
     * @return
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     * 查询用户的所有信息
     * @param userInfo  用户信息  主要使用userId
     * @return
     */
    UserInfo selectUserInfoAll(UserInfo userInfo);

    /**
     *
     * 用户申请权限
     * 向权限列表中插入信息
     * @param permissionInfo  权限信息
     * @return
     */
    int insertPermissionInfo(PermissionInfo permissionInfo);


    /**
     * 忘记密码
     * @param userInfo 用户信息
     * @return
     */
    int updateUserInfoPassword(UserInfo userInfo);

    /**
     * 查询问题的回答是否正确
     * @param userInfo 用户信息
     * @return
     */
    UserInfo selectUserInfoAnswer(UserInfo userInfo);

    /**
     * 根据用户名查找信息
     * @param userName
     * @return
     */
    List<UserInfo> getUserInfoByUserName(String userName);


    /**
     * 根据userId查找用户信息
     * @param userId
     * @return
     */
    UserInfo getUserInfoByUserId(Integer userId);

    /**
     * 获取所有用户信息
     * @return
     */
    List<UserInfo> getUserInfo();

    /**
     * 指定userid成为管理员
     * @param userId
     * @return
     */
    int passUserById(Integer userId);

    /**
     * 申请成为管理员
     */
    int toRoot(Integer userId);

    /**
     * 获取申请成为管理员用户信息
     * @return
     */
    List<UserInfo> getNoPass();
}