package cn.zzu.controller.wx;


import ch.qos.logback.classic.Logger;
import cn.zzu.controller.UserInfoController;
import cn.zzu.util.AuthUtil;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;


@Controller
@RequestMapping("/wx")
public class WxLoginController {


    Logger logger = (Logger) LoggerFactory.getLogger(WxLoginController.class);


    @RequestMapping(value="/login",method = RequestMethod.GET)
    @ResponseBody
    public void Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug("开始微信登录");
        String backUrl ="http://2341gn9675.51mypc.cn/school_war_exploded/call/back";
        URL a = new URL(backUrl);
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID+
                "&redirect_uri=" + a+
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        URL U = new URL(url);
        response.sendRedirect(U.toString());
    }




}
