package cn.zzu.controller;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.Coll;
import cn.zzu.service.CollService;
import cn.zzu.service.GoodsInfoService;
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
 * 商品
 *
 * @author silence
 * @create 2019-04-29-12:02
 */
@Controller
@RequestMapping(value = "coll")
public class CollController {

    @Autowired
    private CollService collService;

    Logger logger = (Logger) LoggerFactory.getLogger(UserInfoController.class);

    @RequestMapping(value="/setColl",method = RequestMethod.POST)
    @ResponseBody
    public String setColl(@RequestBody Map<String,Object> params){
        logger.debug("获取收藏前台传来的数据"+params);
        String desc = params.get("desc").toString();
        String s = params.get("id").toString();
        Integer id = Integer.valueOf(s);
        Coll coll = new Coll();
        coll.setCollDesc(desc);
        coll.setCollImage("/home/image");
        coll.setCollType(1);
        coll.setCreateTime(new Date());
        coll.setId(id);
        Map<String, Object> stringObjectMap = collService.setColl(coll);
        return JsonUtils.map2json(stringObjectMap);
    }


    @RequestMapping(value="/updateColl",method = RequestMethod.POST)
    @ResponseBody
    public String updateColl(@RequestBody Map<String,Object> params){
        logger.debug("获取取消收藏前台传来的数据"+params);
        String goodsIds = params.get("goodsId").toString();
        Integer goodsId = Integer.valueOf(goodsIds);
        Map<String, Object> stringObjectMap = collService.updateColl(goodsId);
        return JsonUtils.map2json(stringObjectMap);
    }

}
