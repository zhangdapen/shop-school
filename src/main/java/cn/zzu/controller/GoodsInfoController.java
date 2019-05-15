package cn.zzu.controller;

import ch.qos.logback.classic.Logger;
import cn.zzu.service.GoodsInfoService;
import cn.zzu.service.OrderInfoService;
import cn.zzu.util.JsonUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品
 *
 * @author silence
 * @create 2019-04-29-12:02
 */
@Controller
@RequestMapping(value = "goods")
public class GoodsInfoController {

    @Autowired
    private GoodsInfoService goodsInfoService;

    Logger logger = (Logger) LoggerFactory.getLogger(UserInfoController.class);

    @RequestMapping(value="/getGoods",method = RequestMethod.POST)
    @ResponseBody
    public String getGoodsInfo(@RequestBody Map<String,Object> params){
        logger.debug("获取所有商品信息前台传来的数据"+params);
        Map<String, Object> goodsInfo = goodsInfoService.getGoodsInfo();
        return JsonUtils.map2json(goodsInfo);
    }



    @RequestMapping(value="/digital",method = RequestMethod.POST)
    @ResponseBody
    public String getGoodsInfoBy(@RequestBody Map<String,Object> params){
        Map<String,Object> result = new HashMap<>();
        logger.debug("获取类别商品前台传来的数据"+params);
        if(params == null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        String ids = params.get("id").toString();
        Integer categoryId = Integer.valueOf(ids);
        Map<String, Object> goodsInfoByCategory = goodsInfoService.getGoodsInfoByCategory(categoryId);
        return JsonUtils.map2json(goodsInfoByCategory);
    }


    @RequestMapping(value="/getGoodsById",method = RequestMethod.POST)
    @ResponseBody
    public String getGoodsById(@RequestBody Map<String,Object> params){
        Map<String,Object> result = new HashMap<>();
        logger.debug("获取特定id商品前台传来的数据"+params);
        if(params == null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        String ids = params.get("goodsId").toString();
        Integer goodsId = Integer.valueOf(ids);
        Map<String, Object> goodsInfoByGoodsId = goodsInfoService.getGoodsInfoByGoodsId(goodsId);
        return JsonUtils.map2json(goodsInfoByGoodsId);
    }

}
