package cn.zzu.controller.wx;


import ch.qos.logback.classic.Logger;
import cn.zzu.util.AuthUtil;
import cn.zzu.util.JsonUtils;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("call")
public class CallBackController {


    Logger logger = (Logger) LoggerFactory.getLogger(CallBackController.class);


    @RequestMapping(value="/back",method = RequestMethod.GET)
    @ResponseBody
    public void Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ AuthUtil.APPID+
                "&secret=" +AuthUtil.APPSECRET+
                "&code=" +code+
                "&grant_type=authorization_code";

        JSONObject jsonObject =AuthUtil.doGetJson(url);
        String openid = jsonObject.getString("openid");
        String token = jsonObject.getString("access_token");

        String infoUrl = " https://api.weixin.qq.com/sns/userinfo?access_token=" +token+
                "&openid=" +openid+
                "&lang=zh_CN";
        URL u =new URL(infoUrl);
        JSONObject userInfo=AuthUtil.doGetJson(u.toString());
        logger.debug("微信登录成功");
        logger.debug("用户信息"+userInfo);
        String nickname = userInfo.getString("nickname");
        String city = userInfo.getString("city");
        String province = userInfo.getString("province");
//        String encoding = JsonUtils.getEncoding(citys);
//        System.out.println("编码格式"+encoding);
//        String city = new String(citys.getBytes("GB2312"),"utf-8");
//        System.out.println("新编码格式"+JsonUtils.getEncoding(city));
        String headimgurl = userInfo.getString("headimgurl");
        HttpSession session = request.getSession();
        session.setAttribute("nickname",nickname);
        session.setAttribute("city",city);
        session.setAttribute("headimgurl",headimgurl);
        session.setAttribute("province",province);
        response.setCharacterEncoding("utf-8");
        response.sendRedirect("/school_war_exploded/manager/owner");
//        response.sendRedirect("/school_war_exploded/manager/owner?nickname="+nickname+"&image="+headimgurl+"&city="+city);
    }
    @RequestMapping(value="/getSession",method = RequestMethod.POST)
    @ResponseBody
    public String getSession(@RequestBody Map<String,Object> param,HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String nickname = session.getAttribute("nickname").toString();
        String city = session.getAttribute("city").toString();
        String headimgurl = session.getAttribute("headimgurl").toString();
        String province = session.getAttribute("province").toString();
        Map<String,Object> result = new HashMap<>();
        result.put("msg",1);
        result.put("nickname",nickname);
        result.put("city",city);
        result.put("headimgurl",headimgurl);
        result.put("province",province);
        return JsonUtils.map2json(result);
    }


}
