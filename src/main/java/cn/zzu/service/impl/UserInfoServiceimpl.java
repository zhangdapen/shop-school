package cn.zzu.service.impl;

import cn.zzu.dao.UserInfoDao;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.entity.UserInfo;
import cn.zzu.execption.MyExecption;
import cn.zzu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        if(StringUtils.isEmpty(userInfo.getUserName())){
            new MyExecption("用户名不能为空");
        }
        if(StringUtils.isEmpty(userInfo.getUserPassword())){
            new MyExecption("密码不能为空");
        }
        if(StringUtils.isEmpty(userInfo.getUserQuestion())){
            new MyExecption("密保问题不能为空");
        }
        if(StringUtils.isEmpty(userInfo.getUserAnswer())){
            new MyExecption("密保回答不能为空");
        }
        if(StringUtils.isEmpty(userInfo.getSchoolId())){
            new MyExecption("学校不能为空");
        }
        int result=userInfoDao.insertUserInfo(userInfo);

        if(result<=0){
            new MyExecption("注册失败");
        }
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

    @Override
    public int updateForgetPassword(UserInfo userInfo) {
        if(StringUtils.isEmpty(userInfo.getUserName())){
            new MyExecption("用户名不能为空");
        }
        if(StringUtils.isEmpty(userInfo.getUserPassword())){
            new MyExecption("密码不能为空");
        }
        if(StringUtils.isEmpty(userInfo.getUserQuestion())){
            new MyExecption("密保问题不能为空");
        }
        if(StringUtils.isEmpty(userInfo.getUserAnswer())){
            new MyExecption("密保回答不能为空");
        }

        UserInfo user = userInfoDao.selectUserInfoAnswer(userInfo);
        if(user == null){
            return 0;
        }
        return userInfoDao.updateUserInfoPassword(userInfo);

    }
}
