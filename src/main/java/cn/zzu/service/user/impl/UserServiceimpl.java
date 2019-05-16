package cn.zzu.service.user.impl;

import ch.qos.logback.classic.Logger;
import cn.zzu.constant.ManagerConstant;
import cn.zzu.core.TokenService;
import cn.zzu.entity.*;
import cn.zzu.execption.MyExecption;
import cn.zzu.service.NewService;
import cn.zzu.service.UserAddrService;
import cn.zzu.service.UserInfoService;
import cn.zzu.service.manager.impl.PermissionInfoServiceImpl;
import cn.zzu.service.user.UserService;
import cn.zzu.util.RandomUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceimpl implements UserService{
    Logger logger = (Logger) LoggerFactory.getLogger(UserService.class);
    //token失效时间
    private final long expireTime = 30*60*60l;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PermissionInfoServiceImpl permissionInfoServiceImpl;
    @Autowired
    private UserAddrService userAddrService;
    @Autowired
    private NewService newService;


    @Override
    public Map<String, Object> login(String userName, String password) throws MyExecption {
        boolean checkLong = this.checkLogin(userName,password);
        Map<String,Object> map = new HashMap<>();
        if(checkLong){
            UserInfo userInfo = userInfoService.getUserInfoByUserName(userName);
            List<UserAddr> userAddr = userInfoService.getUserAddrByUserId(userInfo.getUserId());
            SchoolInfo schoolInfo = userInfoService.getSchoolInfoBySchoolId(userInfo.getSchoolId());
            List<News> news = newService.getNewsByUserId(userInfo.getUserId());
            logger.debug("用户信息"+userInfo);
            logger.debug("地址信息"+userAddr.toString());
            logger.debug("学校信息"+schoolInfo);
            logger.debug("帖子信息"+news.toString());
            long token = tokenService.createToken();
            map.put("userName",userInfo.getUserName());
            map.put("userId",userInfo.getUserId());
            map.put("token",token);
            map.put("expireTime",expireTime);//登录失效时间可配置
            map.put("msg",1);
            map.put("user",userInfo);
            map.put("userAddr",userAddr);
            map.put("schoolInfo",schoolInfo);
            map.put("news",news);
            //TODO:保存token信息,以后的每次请求都需要校验token是否有效
            return map;
        }
        map.put("msg",0);
        return map;
    }
    //检查是否登录成功
    private boolean checkLogin(String userName, String password) throws MyExecption {
        UserInfo userInfo = userInfoService.getUserInfoByUserName(userName);
        if(userInfo == null){
            return false;
        }
        String salt = userInfo.getSalt();//获取用户的salt
        logger.debug("[salt]" + salt);
        String signPwd = DigestUtils.md5Hex(password + salt);
        if(signPwd.equals(userInfo.getUserPassword())){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 注册
     * @param userInfo
     * @return
     * @throws MyExecption
     */
    @Override
    public Map<String, Object> register(UserInfo userInfo) throws MyExecption {
        logger.debug("register start");
        String userName = userInfo.getUserName();
        String password = userInfo.getUserPassword();
        UserInfo olduserInfo = userInfoService.getUserInfoByUserName(userName);
        if(olduserInfo != null){
            throw new MyExecption("用户名已存在");
        }
        String salt = RandomUtils.randomStr(10);
        logger.debug("[salt]" + salt);
        userInfo.setUserPassword(DigestUtils.md5Hex(password + salt));
        userInfo.setSalt(salt);
        logger.debug("[pwd]" + userInfo.getUserPassword());

        int i = userInfoService.insertUserInfo(userInfo);
        Map<String,Object> result = new HashMap<>();
        result.put("result",i);
        return result;
    }

    /**
     *验证用户名是否重复
     * @param username 用户名
     * @return  map信息集合
     * @throws MyExecption
     */
    @Override
    public Map<String, Object> isRepeat(String username) throws MyExecption {
        logger.debug("用户名验证开始");
        Map<String,Object> result = new HashMap<>();
        UserInfo user = userInfoService.getUserInfoByUserName(username);
        System.out.println(user);
        if(user == null){
            result.put("result","0");
            return result;
        }
        result.put("result","1");
        return result;
    }


    /**
     * 密保问题的回答是否正确
     * @param userName
     * @param userAnswer
     * @return
     * @throws MyExecption
     */
    @Override
    public Map<String, Object> isAnswer(String userName,String userAnswer,String userQuestion) throws MyExecption {
        logger.debug("密保验证开始");
        UserInfo userInfo = userInfoService.getUserInfoByUserName(userName);
        logger.debug("根据用户名查找的数据"+userInfo);
        Map<String,Object> result = new HashMap<>();
        if (userInfo == null){
            result.put("msg",0);
            return  result;
        }
        if ( userInfo.getUserQuestion().equals(userQuestion) && userInfo.getUserAnswer().equals(userAnswer)){
            result.put("msg",1);
            return  result;
        }
        result.put("msg",0);
        return  result;
    }


    /**
     * 找回密码
     * @param userName
     * @param userPassword
     * @return
     * @throws MyExecption
     */
    @Override
    public Map<String, Object> findPassword(String userName, String userPassword) throws MyExecption {
        logger.debug("开始找回密码");
        UserInfo userInfo = userInfoService.getUserInfoByUserName(userName);
        String salt = userInfo.getSalt();
        userPassword=DigestUtils.md5Hex(userPassword+salt);
        int userInfoServicePassword = userInfoService.findPassword(userName, userPassword);
        logger.debug("后台返回的信息"+userInfoServicePassword);
        Map<String,Object> result = new HashMap<>();
        result.put("msg",userInfoServicePassword);
        return result;
    }


    /**
     * 根据id找地址
     * @param userId
     * @return
     * @throws MyExecption
     */
    @Override
    public Map<String, Object> findAddr(Integer userId) throws MyExecption {
        Map<String,Object> result = new HashMap<>();
        logger.debug("开始寻找地址");
        List<UserAddr> userAddrByUserId = userInfoService.getUserAddrByUserId(userId);
        logger.debug("后台返回的信息"+userAddrByUserId.toString());
        if(userAddrByUserId.isEmpty()){
            result.put("msg",0);
            return result;
        }
        result.put("userAddr",userAddrByUserId);
        result.put("msg",1);
        return result;
    }


    /**
     * 修改用户信息
     * @param userInfo
     * @return
     * @throws MyExecption
     */
    @Override
    public Map<String, Object> changeInfo(UserInfo userInfo) throws MyExecption {
        Map<String,Object> result = new HashMap<>();
        logger.debug("开始修改信息");
        int i = userInfoService.setUpdateUserInfo(userInfo);
        if(i < 1){
            result.put("msg",0);
            return result;
        }
        result.put("msg",1);
        return result;
    }


    /**
     * 申请成为管理员
     * @return
     * @throws MyExecption
     */
    @Override
    public Map<String, Object> toRootUser(Integer uid,String applicaDes) throws MyExecption {
        Map<String,Object> result = new HashMap<>();
        logger.debug("开始申请超级管理员权限");
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setApplicaId(uid);
        permissionInfo.setApplicaType(ManagerConstant.APPLICA_TYPE_ROOT_SCHOOL);
        permissionInfo.setApplicaDes(applicaDes);
        permissionInfo.setApplicaState(ManagerConstant.APPLICA_STATE_NEW);
        permissionInfoServiceImpl.insertPermissionInfo(permissionInfo);
        return result;
    }

    @Override
    public Map<String, Object> getUserInfoByUserId(Integer userId) throws MyExecption {
        Map<String,Object> result = new HashMap<>();
        logger.debug("开始根据userId查询用户信息");
        UserInfo user = userInfoService.getUserinfoByUserId(userId);
        if(user == null){
            result.put("msg",0);
            return result;
        }
        result.put("msg",1);
        result.put("user",user);
        return result;
    }

    @Override
    public Map<String, Object> setUserAddrByUserId(UserAddr userAddr) throws MyExecption {
        Map<String,Object> result = new HashMap<>();
        logger.debug("开始添加地址");
        int i = userAddrService.setUserAddrByUserId(userAddr);
        if(i < 1){
            result.put("msg",0);
            return  result;
        }
        result.put("msg",i);
        return result;
    }

    /**
     * 根据用户id查询帖子
     * @param userId
     * @return
     * @throws MyExecption
     */
    @Override
    public Map<String, Object> getNewsByUserId(Integer userId) throws MyExecption {
        Map<String,Object> result = new HashMap<>();
        logger.debug("开始查询帖子");
        List<News> newsByUserId = newService.getNewsByUserId(userId);
        int size = newsByUserId.size();
        result.put("size",size);
        result.put("new",newsByUserId);
        return result;
    }


}
