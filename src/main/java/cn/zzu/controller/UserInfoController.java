package cn.zzu.controller;

import cn.zzu.entity.PermissionInfo;
import cn.zzu.entity.User;
import cn.zzu.entity.UserInfo;
import cn.zzu.service.UserInfoService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
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
    @RequestMapping(value="/register",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String register(UserInfo userInfo,@RequestParam String userName,
    @RequestParam  String userPassword,@RequestParam  Integer schoolId,@RequestParam  String userQuestion,
                           @RequestParam  String userAnswer
    ){
        System.out.println("我是controller");
        System.out.println(userInfo.toString());
        int result = userInfoService.setInsertUserInfo(userInfo);
        if(result>0){
            return "login";
        }else{
            return "register";
        }
    }

    @RequestMapping(value="/register1997")
    @ResponseBody
    public String register1997(@RequestBody User user){
        System.out.println("我是controller");
        System.out.println(user.getUserName()+"===="+user.getPassword());
        return  "register";
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

    @RequestMapping(value="forget",method=RequestMethod.POST)
    @ResponseBody
    public String changeAndForgetPass(UserInfo userInfo){
        int i = userInfoService.setUpdateForgetPassword(userInfo);
        if(i>0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }
}
