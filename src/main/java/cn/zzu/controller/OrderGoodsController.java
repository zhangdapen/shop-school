package cn.zzu.controller;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.OrderGoods;
import cn.zzu.entity.OrderInfo;
import cn.zzu.service.OrderGoodsService;
import cn.zzu.service.OrderInfoService;
import cn.zzu.util.JsonUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 订单商品
 *
 * @author silence
 * @create 2019-04-29-12:02
 */
@Controller
@RequestMapping(value = "ordergoods")
public class OrderGoodsController {

    Logger logger = (Logger) LoggerFactory.getLogger(OrderGoodsController.class);

    @Autowired
    private OrderGoodsService orderGoodsService;


    @RequestMapping(value = "/setordergoods",method = RequestMethod.POST)
    @ResponseBody
    public String setOrderGoods(@RequestBody Map<String,Object> params){
        logger.debug("前台传来的订单商品数据"+params);
        String s = params.get("orderId").toString();
        Integer orderId = Integer.valueOf(s);
        List<Integer> goodsIds=(List<Integer>)params.get("goodsIds");

        List<OrderGoods> orderGoods1 = new ArrayList<>();
        for (int i =0 ;i<goodsIds.size();i++){
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setOrderId(orderId);
            orderGoods.setCreateTime(new Date());
            String s1 = goodsIds.get(i).toString();
            Integer goodsId = Integer.valueOf(s1);
            orderGoods.setGoodsId(goodsId);
            orderGoods1.add(orderGoods);
        }
        Map<String, Object> stringObjectMap = orderGoodsService.setInsertOrderGoods(orderGoods1);
        return JsonUtils.map2json(stringObjectMap);
    }



}
