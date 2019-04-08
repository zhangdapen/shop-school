package cn.zzu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录controller
 *
 * @author silence
 * @create 2019-02-20-9:47
 */
@Controller
@RequestMapping(value="manager")
public class ManagerController {

    @RequestMapping(value="/register")
    public String register(){
       return "register";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value="/new")
    public String zzz(){
        return "zzz";
    }

    @RequestMapping(value="/test")
    public String test(){
        return "test";
    }
}
