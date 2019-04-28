package cn.zzu.service.user;

import cn.zzu.entity.PermissionInfo;
import cn.zzu.entity.UserAddr;
import cn.zzu.entity.UserInfo;
import cn.zzu.execption.MyExecption;

import java.util.Map;


public interface UserService {
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     * @throws MyExecption
     */
    Map<String,Object> login(String userName,String password) throws MyExecption;

    /**
     * 注册
     * @param userInfo
     * @return
     * @throws MyExecption
     */
    Map<String,Object> register(UserInfo userInfo) throws MyExecption;

    /**
     * 验证用户名是否重复
     * @param username
     * @return
     * @throws MyExecption
     */
    Map<String,Object> isRepeat(String username) throws MyExecption;

    /**
     * 验证密保的正确性
     * @param userName
     * @param userAnswer
     * @param userQuestion
     * @return
     * @throws MyExecption
     */
    Map<String,Object> isAnswer(String userName,String userAnswer,String userQuestion) throws MyExecption;

    /**
     * 找回密码
     * @param userName
     * @param userPassword 新密码
     * @return
     * @throws MyExecption
     */
    Map<String,Object> findPassword(String userName,String userPassword) throws  MyExecption;

    /**
     * 在userAddr表中查找地址信息
     * @param userId
     * @return
     * @throws MyExecption
     */
    Map<String,Object> findAddr(Integer userId)  throws MyExecption;

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     * @throws MyExecption
     */
    Map<String,Object> changeInfo(UserInfo userInfo)  throws MyExecption;

    /**
     * 成为管理员
     * @param permissionInfo
     * @return
     * @throws MyExecption
     */
    Map<String,Object> toRootUser(PermissionInfo permissionInfo) throws MyExecption;

    /**
     * 根据userId获取用户信息
     * @param userId
     * @return
     * @throws MyExecption
     */
    Map<String,Object> getUserInfoByUserId(Integer userId) throws MyExecption;

    /**
     * 根据userId设置地址
     * @param userAddr
     * @return
     * @throws MyExecption
     */
    Map<String,Object> setUserAddrByUserId(UserAddr userAddr) throws MyExecption;

    /**
     * 根据用户di查询帖子信息
     * @param userId
     * @return
     * @throws MyExecption
     */
    Map<String,Object> getNewsByUserId(Integer userId) throws  MyExecption;
}
