package cn.zzu.controller;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.*;
import cn.zzu.execption.MyExecption;
import cn.zzu.service.InfoService;
import cn.zzu.service.UserInfoService;
import cn.zzu.service.user.UserService;
import cn.zzu.util.BeanUtil;
import cn.zzu.util.JsonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录的Controller
 *
 * @author silence
 * @create 2019-02-22-13:21
 */

@Controller
@RequestMapping(value="admin")
public class UserInfoController {

    Logger logger = (Logger) LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;

    @Autowired
    private InfoService infoService;

    /**
     * 登录   controller实现
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    //public String login(UserInfo userInfo, HttpSession session) throws MyExecption{
    public String login(@RequestBody Map<String,Object> params,HttpSession session) throws MyExecption{
        logger.debug("[login params]"+params);
        Map<String,Object> result = new HashMap<>();
        if(params == null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        String userName = params.get("userName").toString();
        String password = params.get("userPassword").toString();
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        Map<String,Object> loginResult = userService.login(userName,password);
        if(loginResult.get("msg").equals(1)){
            UserInfo user = (UserInfo) loginResult.get("user");
            List<UserAddr> addr=(List<UserAddr>)loginResult.get("userAddr");
            SchoolInfo school=(SchoolInfo)loginResult.get("schoolInfo");
            List<News> news=(List<News>)loginResult.get("news");
            session.setAttribute("user",user);
            session.setAttribute("addr",addr);
            session.setAttribute("school",school);
            session.setAttribute("news",news);
            logger.debug("session数据"+user);
            logger.debug("session数据"+addr);
            logger.debug("session数据"+school);
            logger.debug("session数据"+news);
        }
        return JsonUtils.map2json(loginResult);
    }


    /**
     * 注册controller实现
     * @return 地址字符串
     */
    @RequestMapping(value="/register",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String register(@RequestBody Map<String,Object> params)throws MyExecption{
        logger.debug("后台传来数据"+params);
        if(params == null){
            return "admin/register";
        }
        UserInfo userInfo =new UserInfo();
        UserInfo user = BeanUtil.map2Bean(params, userInfo.getClass());
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
        Map<String,Object> result = userService.register(user);
        System.out.println(result.toString());
        return JsonUtils.map2json(result);
    }



    @RequestMapping(value="/findPassword",method = RequestMethod.POST)
    @ResponseBody
    public String password(@RequestBody Map<String,Object> params) throws MyExecption{
        logger.debug("前端传来找回密码信息"+params);
        Map<String,Object> result = new HashMap<>();
        if(params == null){
            result.put("msg",0);
            return  JsonUtils.map2json(result);
        }
        String userName = params.get("userName").toString();
        String userPassword = params.get("userPassword").toString();
        Map<String, Object> userServicePassword = userService.findPassword(userName, userPassword);
        return JsonUtils.map2json(userServicePassword);
    }

    /**
     * 验证注册的时候用户名是否重复
     * @param params
     * @return
     * @throws MyExecption
     */
    @RequestMapping(value="/isRepeat",method = RequestMethod.POST)
    @ResponseBody
    public String isRepeat(@RequestBody Map<String,Object> params)throws MyExecption {
        logger.debug("前台传来的数据"+params);
        Map<String,Object> result = new HashMap<>();
        if(params == null){
            return JsonUtils.map2json(result);
        }
        String userName = params.get("userName").toString();
        System.out.println(userName);
        Map<String, Object> userServiceRepeat = userService.isRepeat(userName);
        logger.debug("后台验证用户名的数据"+userServiceRepeat);
        return JsonUtils.map2json(userServiceRepeat);
    }

    /**
     * 验证修改密码时的密保问题
     * @param params
     * @return
     * @throws MyExecption
     */
    @RequestMapping(value="/isAnswer",method = RequestMethod.POST)
    @ResponseBody
    public String isAnswer(@RequestBody Map<String,Object> params)throws MyExecption {
        logger.debug("密保问题传来的数据"+params);
        Map<String,Object> result = new HashMap<>();
        if(params == null){
            result.put("msg",0);
            return  JsonUtils.map2json(result);
        }
        String userName = params.get("userName").toString();
        String userAnswer = params.get("userAnswer").toString();
        String userQuestion = params.get("userQuestion").toString();
        Map<String, Object> userServiceAnswer = userService.isAnswer(userName, userAnswer,userQuestion);
        logger.debug("密保问题验证后台传来的数据"+userServiceAnswer.toString());
        return JsonUtils.map2json(userServiceAnswer);

    }

    /**
     * 通过userID找到地址
     * @param params
     * @return
     * @throws MyExecption
     */
    @RequestMapping(value = "/findAddr")
    @ResponseBody
    public String findAddr(@RequestBody Map<String,Object> params) throws MyExecption {
        logger.debug("修改地址传来的数据"+params);
        Map<String,Object> result = new HashMap<>();
        if (params == null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        String userIds = params.get("userId").toString();
        Integer userId = Integer.valueOf(userIds);
        Map<String, Object> addr = userService.findAddr(userId);
        return JsonUtils.map2json(addr);
    }


    /**
     * 获取到session中存储的
     * 用户信息,地址信息,学校信息,帖子信息
     * @param params
     * @param request
     * @return
     */
    @RequestMapping(value = "/info",method = RequestMethod.POST)
    @ResponseBody
    public String getSession(@RequestBody Map<String,Object> params,HttpServletRequest request){
        Map<String,Object> result= new HashMap<>();
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo)session.getAttribute("user");
        List<UserAddr> userAddr=(List<UserAddr>) session.getAttribute("addr");
        SchoolInfo schoolInfo=(SchoolInfo)session.getAttribute("school");
        List<News> news=(List<News>)session.getAttribute("news");
        System.out.println(user);
        System.out.println(userAddr.toString());
        System.out.println(schoolInfo);
        System.out.println(news);
        result.put("user",user);
        result.put("userAddr",userAddr);
        result.put("schoolInfo",schoolInfo);
        result.put("news",news);
        result.put("size",news.size());
        result.put("userInfoId",user.getUserId());
        result.put("msg",1);
        return JsonUtils.map2json(result);
    }

    /**
     * 修改用户信息
     * @param params
     * @return
     * @throws MyExecption
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String updateInfo(@RequestBody Map<String,Object> params) throws MyExecption {
        logger.debug("前台传来的修改数据"+params);
        Map<String,Object> result = new HashMap<>();
        if(params == null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        String userNickname = params.get("userNickname").toString();
        String userIds = params.get("userId").toString();
        Integer userId = Integer.valueOf(userIds);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserNickname(userNickname);
        userInfo.setUserId(userId);
        Map<String, Object> stringObjectMap = userService.changeInfo(userInfo);
        return JsonUtils.map2json(stringObjectMap);
    }


    @RequestMapping(value = "/setPhone",method = RequestMethod.POST)
    @ResponseBody
    public String setPhone(@RequestBody Map<String,Object> params) throws MyExecption {
        logger.debug("前台传来的修改数据"+params);
        Map<String,Object> result = new HashMap<>();
        if(params == null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        String phone = params.get("phone").toString();
        String userIds = params.get("userId").toString();
        Integer userId = Integer.valueOf(userIds);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPhone(phone);
        userInfo.setUserId(userId);
        Map<String, Object> stringObjectMap = userService.changeInfo(userInfo);
        return JsonUtils.map2json(stringObjectMap);
    }

    /**
     * 申请成为管理员
     * @param params
     * @return
     * @throws MyExecption
     */
    @RequestMapping(value = "/toRoot",method = RequestMethod.POST)
    @ResponseBody
    public String toRoot(@RequestBody Map<String,Object> params) throws MyExecption {
        logger.debug("修改权限前台传来的数据"+params);
        Map<String,Object> result = new HashMap<>();
        if (params == null){
            result.put("msg",0);
            return  JsonUtils.map2json(result);
        }
        String userIds = params.get("userId").toString();
        Integer userId = Integer.valueOf(userIds);
        Map<String, Object> stringObjectMap = userInfoService.toRoot(userId);
//        String applicaType=params.get("applicaType").toString();
//        String applicaDes=params.get("applicaDes").toString();
//        PermissionInfo permissionInfo = new PermissionInfo();
//        permissionInfo.setApplicaId(userId);
//        permissionInfo.setApplicaType(applicaType);
//        permissionInfo.setApplicaDes(applicaDes);
//        permissionInfo.setCreateTime(new Date());
//        permissionInfo.setApplicaState("0");
//        Map<String, Object> stringObjectMap = userService.toRootUser(permissionInfo);
        return JsonUtils.map2json(stringObjectMap);
    }

    /**
     * 根据userId获取用户信息
     * @param params
     * @return
     * @throws MyExecption
     */
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getUserInfo(@RequestBody Map<String,Object> params) throws MyExecption {
        logger.debug("前台传来的UserId数据"+params);
        Map<String,Object> result = new HashMap<>();
        if (params == null){
            result.put("msg",0);
            return  JsonUtils.map2json(result);
        }
        String userIds = params.get("userId").toString();
        String[] split = userIds.split(":");
        Integer userId = Integer.valueOf(split[1]);
        System.out.println(userId);
        Map<String, Object> userInfoByUserId = userService.getUserInfoByUserId(userId);
        return  JsonUtils.map2json(userInfoByUserId);
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    @ResponseBody
    public String getUser(@RequestBody Map<String,Object> params) throws MyExecption {
        logger.debug("前台传来的UserId数据"+params);
        Map<String,Object> result = new HashMap<>();
        if (params == null){
            result.put("msg",0);
            return  JsonUtils.map2json(result);
        }
        String userIds = params.get("userId").toString();
        Integer userId = Integer.valueOf(userIds);
        System.out.println(userId);
        Map<String, Object> userInfoByUserId = userService.getUserInfoByUserId(userId);
        return  JsonUtils.map2json(userInfoByUserId);
    }

    /**
     * 添加地址到userAddr表
     * @param params
     * @return
     * @throws MyExecption
     */
    @RequestMapping(value = "/setAddr",method = RequestMethod.POST)
    @ResponseBody
    public String setAddr(@RequestBody Map<String,Object> params) throws MyExecption {
        logger.debug("前台传来的地址数据"+params);
        Map<String,Object> result = new HashMap<>();
        if (params == null){
            result.put("msg",0);
            return  JsonUtils.map2json(result);
        }
        String userIds = params.get("userId").toString();
        String[] split = userIds.split(":");
        Integer userId = Integer.valueOf(userIds);
        String addrDesc=params.get("addr").toString();
        UserAddr userAddr = new UserAddr();
        userAddr.setUserId(userId);
        userAddr.setAddrState(0);
        userAddr.setAddrDesc(addrDesc);
        userAddr.setCreateTime(new Date());
        Map<String, Object> stringObjectMap = userService.setUserAddrByUserId(userAddr);
        return  JsonUtils.map2json(stringObjectMap);
    }

    @RequestMapping(value = "/getInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getInfo(@RequestBody Map<String,Object> params) throws MyExecption {
        logger.debug("前台传来的id数据"+params);
        Map<String,Object> result = new HashMap<>();
        if (params == null){
            result.put("msg",0);
            return  JsonUtils.map2json(result);
        }
        String id = params.get("id").toString();
        Integer userId = Integer.valueOf(id);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        Map<String, Object> info = infoService.getInfo(userInfo);
        return  JsonUtils.map2json(info);
    }



}
