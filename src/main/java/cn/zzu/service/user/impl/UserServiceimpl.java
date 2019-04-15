package cn.zzu.service.user.impl;

import cn.zzu.Utils.RandomUtils;
import cn.zzu.core.TokenService;
import cn.zzu.entity.UserInfo;
import cn.zzu.execption.MyExecption;
import cn.zzu.service.UserInfoService;
import cn.zzu.service.user.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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



    @Override
    public Map<String, Object> login(String userName, String password) throws MyExecption {
        boolean checkLong = this.checkLogin(userName,password);
        if(checkLong){
            UserInfo userInfo = userInfoService.getUserInfoByUserName(userName);
            long token = tokenService.createToken();
            Map<String,Object> map = new HashMap<>();
            map.put("userName",userInfo.getUserName());
            map.put("userId",userInfo.getUserId());
            map.put("token",token);
            map.put("expireTime",expireTime);//登录失效时间可配置

            //TODO:保存token信息,以后的每次请求都需要校验token是否有效
            return map;

        }
        return null;
    }

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

        userInfoService.insertUserInfo(userInfo);
        return null;
    }

    private boolean checkLogin(String userName, String password) throws MyExecption {
        UserInfo userInfo = userInfoService.getUserInfoByUserName(userName);
        if(userInfo == null){
            throw new MyExecption("用户不存在");
        }
        String salt = userInfo.getSalt();//获取用户的salt
        logger.debug("[salt]" + salt);
        String signPwd = DigestUtils.md5Hex(password + salt);

        if(signPwd.equals(userInfo.getUserPassword())){
            return true;
        }else{
            throw new MyExecption("密码错误");
        }

    }




}
