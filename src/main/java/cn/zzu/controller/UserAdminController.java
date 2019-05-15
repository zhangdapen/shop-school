package cn.zzu.controller;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.Coll;
import cn.zzu.entity.UserInfo;
import cn.zzu.service.CollService;
import cn.zzu.service.UserInfoService;
import cn.zzu.util.JsonUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品
 *
 * @author silence
 * @create 2019-04-29-12:02
 */
@Controller
@RequestMapping(value = "useradmin")
public class UserAdminController {


    @Autowired
    private UserInfoService userInfoService;

    Logger logger = (Logger) LoggerFactory.getLogger(UserAdminController.class);

    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public String setColl(@RequestBody Map<String,Object> params){
        Map<String,Object> result = new HashMap<>();
        String username = params.get("username").toString();
        String pass = params.get("pass").toString();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(username);
        UserInfo user = userInfoService.getUserInfoByUserName(username);
        String salt = user.getSalt();
        String s = DigestUtils.md5Hex(pass + salt);
        if(s.equals(user.getUserPassword()) && user.getUserType()==0){
            result.put("msg",1);
            return JsonUtils.map2json(result);
        }
        result.put("msg",0);
        return  JsonUtils.map2json(result);
    }




}
