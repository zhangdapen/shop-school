package cn.zzu.controller;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.Coll;
import cn.zzu.entity.UserCart;
import cn.zzu.service.CollService;
import cn.zzu.service.UserCartService;
import cn.zzu.util.JsonUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车
 *
 * @author silence
 * @create 2019-04-29-12:02
 */
@Controller
@RequestMapping(value = "car")
public class UserCartController {

    @Autowired
    private UserCartService userCartService;

    Logger logger = (Logger) LoggerFactory.getLogger(UserInfoController.class);

    @RequestMapping(value="/setCar",method = RequestMethod.POST)
    @ResponseBody
    public String setCar(@RequestBody Map<String,Object> params){
        logger.debug("获取添加商品到购物车前台传来的数据"+params);
        String userIds = params.get("userId").toString();
        Integer userId = Integer.valueOf(userIds);
        String goodsIds = params.get("goodsId").toString();
        Integer goodId = Integer.valueOf(goodsIds);
        UserCart userCart = new UserCart();
        userCart.setUserId(userId);
        userCart.setGoodsId(goodId);
        userCart.setCreateTime(new Date());
        Map<String, Object> stringObjectMap = userCartService.setInsertUserCartInfo(userCart);
        return JsonUtils.map2json(stringObjectMap);
    }


    @RequestMapping(value="/getCar",method = RequestMethod.POST)
    @ResponseBody
    public String getCar(@RequestBody Map<String,Object> params){
        logger.debug("获取购物车信息前台传来的数据"+params);
        Map<String,Object> result = new HashMap<>();
        if(params == null){
            result.put("msg",1);
            return JsonUtils.map2json(result);
        }
        String userIds = params.get("userId").toString();
        Integer userId = Integer.valueOf(userIds);
        Map<String, Object> selectUserCarInfo = userCartService.getSelectUserCarInfo(userId);
        return JsonUtils.map2json(selectUserCarInfo);
    }




}
