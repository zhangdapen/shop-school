package cn.zzu.controller;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.entity.UserInfo;
import cn.zzu.execption.MyExecption;
import cn.zzu.service.UserInfoService;
import cn.zzu.service.user.UserService;
import cn.zzu.util.BeanUtil;
import cn.zzu.util.JsonUtils;
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
import java.util.HashMap;
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


    /**
     * 登录   controller实现
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    //public String login(UserInfo userInfo, HttpSession session) throws MyExecption{
    public String login(@RequestBody Map<String,Object> params) throws MyExecption{
        logger.debug("[login params]"+params);
        Map<String,Object> result = new HashMap<>();
        /*UserInfo user = userInfoService.getSelectUserInfo(userInfo);
        if(user==null){
            //登录失败
            return null;
        }else{
            //登录成功
            session.setAttribute("userInfo",user);
            return null;
        }*/
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



    /**
     * 修改用户信息controller实现
     * @param userInfo  用户信息类
     * @param request   request
     * @param response  response
     * @return 地址串
     * @throws UnsupportedEncodingException 字符编码
     */
    @RequestMapping(value="/change",method = RequestMethod.POST)
    @ResponseBody
    public String change(UserInfo userInfo, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int i = userInfoService.setUpdateUserInfo(userInfo);
        //检查是否有密码的修改
        if(userInfo.getUserPassword()==null){
            //没密码的修改,跳转到主页
            if(i>0){
                return "主页";
            }
            return "注册页面";

        }else{
            if(i>0){
                return "登录页面";
            }
            return "修改信息页面";
        }
    }

    /**
     * 获取用户信息controller层
     * @param userInfo 用户类
     * @return
     */
    @RequestMapping(value="select",method=RequestMethod.GET)
    @ResponseBody
    public String select(UserInfo userInfo){
        UserInfo user = userInfoService.getSelectUserInfoAll(userInfo);
        //把java对象转化成json字符串
        String s = JSONObject.toJSONString(userInfo);
        return s;
    }

    @RequestMapping(value="permiss",method=RequestMethod.POST)
    public String changePermission(PermissionInfo permissionInfo){
        int i = userInfoService.setInsertPermissionInfo(permissionInfo);
        if(i==1){
            return "已经提交申请";
        }else{
            return "请重试";
        }
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

}
