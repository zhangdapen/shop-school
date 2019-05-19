package cn.zzu.controller.root;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.Ad;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.UserInfo;
import cn.zzu.service.AdService;
import cn.zzu.service.GoodsInfoService;
import cn.zzu.service.UserInfoService;
import cn.zzu.service.user.UserService;
import cn.zzu.util.JsonUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 后台管理
 *
 * @author silence
 * @create 2019-04-29-12:02
 */
@Controller
@RequestMapping(value = "super")
public class RootController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdService adService;

    @Autowired
    private GoodsInfoService goodsInfoService;

    Logger logger = (Logger) LoggerFactory.getLogger(RootController.class);

    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public String setColl(@RequestBody Map<String,Object> params){
        logger.debug("======后台管理=====");
        logger.debug("获得后台管理登录数据"+params);

        String username = params.get("username").toString();
        String password = params.get("password").toString();
        UserInfo userInfoByUserName = userInfoService.getUserInfoByUserName(username);
        Map<String,Object> result =new HashMap<>();
        if (userInfoByUserName==null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        String userPassword = userInfoByUserName.getUserPassword();
        Integer userType = userInfoByUserName.getUserType();
        String salt = userInfoByUserName.getSalt();
        if(userType == 1){
            result.put("msg","账户不是管理员");
            return JsonUtils.map2json(result);
        }
        String signPwd = DigestUtils.md5Hex(password + salt);
        if(!userPassword.equals(signPwd)){
            result.put("msg","密码错误");
            return JsonUtils.map2json(result);
        }
        result.put("msg",1);
        return JsonUtils.map2json(result);
    }

    @RequestMapping(value="/getUser",method = RequestMethod.POST)
    @ResponseBody
    public String getUser(@RequestBody Map<String,Object> params){
        logger.debug("======初始化用户管理=====");
        logger.debug("获得后台数据"+params);
        Map<String, Object> userInfo = userInfoService.getUserInfo();
        return JsonUtils.map2json(userInfo);
    }

    /**
     * 获取审核商品
     * @param params
     * @return
     */
    @RequestMapping(value="/getGoods",method = RequestMethod.POST)
    @ResponseBody
    public String getGoods(@RequestBody Map<String,Object> params){
        logger.debug("======初始化审核=====");
        logger.debug("获得后台数据"+params);
        Map<String, Object> goodsNoPass = goodsInfoService.getGoodsNoPass();
        return JsonUtils.map2json(goodsNoPass);
    }

    /**
     * 商品通过审核
     * @param params
     * @return
     */
    @RequestMapping(value="/passGoods",method = RequestMethod.POST)
    @ResponseBody
    public String passGoods(@RequestBody Map<String,Object> params){
        logger.debug("======指定商品提供审核=====");
        logger.debug("获得后台数据"+params);
        Integer goodsId = Integer.valueOf(params.get("goodsId").toString());
        Map<String, Object> stringObjectMap = goodsInfoService.passGoodsById(goodsId);
        return JsonUtils.map2json(stringObjectMap);
    }

    /**
     * 用户设置管理员
     * @param params
     * @return
     */
    @RequestMapping(value="/passUser",method = RequestMethod.POST)
    @ResponseBody
    public String passUser(@RequestBody Map<String,Object> params){
        logger.debug("======指定用户成为管理员=====");
        logger.debug("获得后台数据"+params);
        Integer userId = Integer.valueOf(params.get("userId").toString());
        Map<String, Object> stringObjectMap = userInfoService.passUserById(userId);
        return JsonUtils.map2json(stringObjectMap);
    }

    @RequestMapping(value="/getNoPass",method = RequestMethod.POST)
    @ResponseBody
    public String getNoPass(@RequestBody Map<String,Object> params){
        logger.debug("======获取申请root用户信息=====");
        logger.debug("获得后台数据"+params);
        Map<String, Object> noPass = userInfoService.getNoPass();
        return JsonUtils.map2json(noPass);
    }

    @RequestMapping(value="/toupload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        logger.debug("======上传图片=====");
        //上传的路径
        String path = "http://59.110.213.231:8080/image/goods/";
        String filename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename=uuid+"_"+filename;
        //创建客户端对象
        Client client = Client.create();
        WebResource resource = client.resource(path + filename);
        //上传文件
        resource.put(file.getBytes());
        logger.debug("上传成功");
        //把名字写入数据库
        Ad ad = new Ad();
        ad.setAdIamge(filename);
        ad.setCreateTime(new Date());
        ad.setAdState(1);
        Map<String, Object> stringObjectMap = adService.setAd(ad);
        if(Integer.valueOf(stringObjectMap.get("msg").toString()) == 1){
            return "添加成功";
        }
        return "添加失败";
    }

    /**
     * 获取所有广告信息
     * @param params
     * @return
     */
    @RequestMapping(value="/deleteAd",method = RequestMethod.POST)
    @ResponseBody
    public String deleteAd(@RequestBody Map<String,Object> params){
        logger.debug("======删除广告=====");
        logger.debug("获得后台数据"+params);
        Integer adId = Integer.valueOf(params.get("adId").toString());
        Map<String, Object> stringObjectMap = adService.deleteAdById(adId);
        return JsonUtils.map2json(stringObjectMap);
    }

    @RequestMapping(value="/getAllAd",method = RequestMethod.POST)
    @ResponseBody
    public String getAllAd(@RequestBody Map<String,Object> params){
        logger.debug("======指定用户成为管理员=====");
        logger.debug("获得后台数据"+params);
        Map<String, Object> ad = adService.getAd();
        return JsonUtils.map2json(ad);
    }


}
