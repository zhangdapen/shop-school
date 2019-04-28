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
       return "user/register";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping(value="/password")
    public String password(){
        return "user/password";
    }

    @RequestMapping(value="/test")
    public String test(){
        return "test";
    }


    @RequestMapping(value = "/owner")
    public String owner(){
        return "main/owner";
    }

    @RequestMapping(value="/menu")
    public String menu(){
        return "main/menu";
    }


    @RequestMapping(value = "/info")
    public String info(){
        return "user/info";
    }

    @RequestMapping(value = "/addr")
    public String addr(){
        return "user/addr";
    }

    @RequestMapping(value = "/pay")
    public String pay(){
        return "user/pay";
    }


    @RequestMapping(value = "/release")
    public String release(){
        return "user/release";
    }

    @RequestMapping(value = "/shopping")
    public String shopping(){
        return "shop/shopping";
    }
}
