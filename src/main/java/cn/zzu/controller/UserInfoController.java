package cn.zzu.controller;

import cn.zzu.entity.UserInfo;
import cn.zzu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * 登录的Controller
 *
 * @author silence
 * @create 2019-02-22-13:21
 */

@Controller
@RequestMapping(value="admin")
public class UserInfoController {


    @Autowired
    private UserInfoService userInfoService;

    /**
     * 登录   controller实现
     * @param userInfo 用户信息
     * @param session session
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(UserInfo userInfo, HttpSession session){
        UserInfo user = userInfoService.getSelectUserInfo(userInfo);
        if(user==null){
            //登录失败
            return null;
        }else{
            //登录成功
            session.setAttribute("userInfo",user);
            return null;
        }
    }


    /**
     * 注册controller实现
     * @param userInfo 用户信息类
     * @return 地址字符串
     */
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(UserInfo userInfo){
        int result = userInfoService.setInsertUserInfo(userInfo);
        if(result>0){
            return "login";
        }else{
            return "register";
        }
    }

    /**
     * 修改用户controller实现
     * @param userInfo  用户信息类
     * @param request   request
     * @param response  response
     * @return 地址串
     * @throws UnsupportedEncodingException 字符编码
     */
    @RequestMapping(value="/change",method = RequestMethod.POST)
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
     * 获取用户信息dao层
     * @param userInfo 用户类
     * @return
     */
    @RequestMapping(value="select",method=RequestMethod.GET)
    @ResponseBody
    public UserInfo select(UserInfo userInfo){
        UserInfo user = userInfoService.getSelectUserInfoAll(userInfo);
        return user;
    }


}
