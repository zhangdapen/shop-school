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
     * @param userInfo 用户信息
     * @param session session
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    //public String login(UserInfo userInfo, HttpSession session) throws MyExecption{
    public String login(@RequestBody Map<String,Object> params) throws MyExecption{
        logger.debug("[login params]"+params);

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
            throw new MyExecption("参数有误");
        }
        String userName = params.get("userName").toString();
        String password = params.get("userPassword").toString();
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            throw new MyExecption("用户名或密码不正确");
        }
        Map<String,Object> restut = userService.login(userName,password);
        return JsonUtils.map2json(restut);
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
        Map<String,Object> restut = userService.register(user);
        return JsonUtils.map2json(restut);
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



    @RequestMapping("value=/password")
    @ResponseBody
    public String password(@RequestBody Map<String,Object> params){
        logger.debug("后台传来的数据"+params);
        if(params == null){
            return "admin/password";
        }
        return null;
    }
}
