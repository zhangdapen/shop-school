package cn.zzu.dao;


import cn.zzu.entity.UserInfo;


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


}