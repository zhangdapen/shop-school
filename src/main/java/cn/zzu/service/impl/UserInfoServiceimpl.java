package cn.zzu.service.impl;

import cn.zzu.dao.SchoolInfoDao;
import cn.zzu.dao.UserAddrDao;
import cn.zzu.dao.UserInfoDao;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.entity.SchoolInfo;
import cn.zzu.entity.UserAddr;
import cn.zzu.entity.UserInfo;
import cn.zzu.execption.MyExecption;
import cn.zzu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private UserAddrDao userAddrDao;

    @Autowired
    private SchoolInfoDao schoolInfoDao;
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


    /**
     * 根据userId查找地址信息
     * @param userId
     * @return
     */
    @Override
    public List<UserAddr> getUserAddrByUserId(Integer userId) {
        return userAddrDao.getUserAddrByUserId(userId);
    }


    /**
     * 根据学校id查询学校信息
     * @param schoolId
     * @return
     */
    @Override
    public SchoolInfo getSchoolInfoBySchoolId(Integer schoolId){
        return schoolInfoDao.getSchoolInfoBySchoolId(schoolId);
    }

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    @Override
    public UserInfo getUserinfoByUserId(Integer userId) {
        return userInfoDao.getUserInfoByUserId(userId);
    }

    @Override
    public Map<String, Object> getUserInfo() {
        List<UserInfo> userInfo = userInfoDao.getUserInfo();
        Map<String,Object> result = new HashMap<>();
        if(userInfo.size() == 0){
            result.put("msg",0);
            return result;
        }
        result.put("size",userInfo.size());
        result.put("userInfo",userInfo);
        result.put("msg",1);
        return result;
    }

    /**
     * 指定userId成为管理员
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> passUserById(Integer userId) {
        int i = userInfoDao.passUserById(userId);
        Map<String,Object> result = new HashMap<>();
        if(i <=0){
            result.put("msg",0);
            return result;
        }
        result.put("msg",i);
        return result;
    }

    @Override
    public Map<String, Object> toRoot(Integer userId) {
        int i = userInfoDao.toRoot(userId);
        Map<String,Object> result = new HashMap<>();
        if(i <= 0){
            result.put("msg",0);
            return result;
        }
        result.put("msg",1);
        return result;
    }

    @Override
    public Map<String, Object> getNoPass() {
        List<UserInfo> noPass = userInfoDao.getNoPass();
        Map<String,Object> result = new HashMap<>();
        if(noPass.size()<=0){
            result.put("msg",0);
            return result;
        }
        result.put("msg",1);
        result.put("size",noPass.size());
        result.put("user",noPass);
        return result;
    }


}
