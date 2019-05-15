package cn.zzu.controller;

import ch.qos.logback.classic.Logger;
import cn.zzu.entity.OrderInfo;
import cn.zzu.service.OrderInfoService;
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
@RequestMapping(value = "order")
public class OrderInfoController {

    Logger logger = (Logger) LoggerFactory.getLogger(UserInfoController.class);


    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping(value = "/getOrder",method = RequestMethod.POST)
    @ResponseBody
    public String getOrderInfo(@RequestBody Map<String,Object> params){
        logger.debug("前台传来的OrderId数据"+params);
        Map<String,Object> result = new HashMap<>();
        if(params == null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        Integer OrderId = Integer.valueOf(params.get("orderId").toString());
        Map<String, Object> orderInfoByOrderId = orderInfoService.getOrderInfoByOrderId(OrderId);
        logger.debug("后台返回订单数据"+orderInfoByOrderId.toString());
        orderInfoByOrderId.put("msg",1);
        return JsonUtils.map2json(orderInfoByOrderId);
    }


    @RequestMapping(value = "/setOrder",method = RequestMethod.POST)
    @ResponseBody
    public String setOrder(@RequestBody Map<String,Object> params){
        logger.debug("前台传来的订单数据"+params);
        Map<String,Object> result = new HashMap<>();
        if(params == null){
            result.put("msg",0);
            return JsonUtils.map2json(result);
        }
        OrderInfo orderInfo = new OrderInfo();
        String amounts = params.get("amount").toString();
        Double amount = Double.valueOf(amounts);
        String addrIds = params.get("addId").toString();
        Integer addrId = Integer.valueOf(addrIds);
        orderInfo.setAddrId(addrId);
        orderInfo.setOrderAmount(amount);
        orderInfo.setCreateTime(new Date());
        Map<String, Object> stringObjectMap = orderInfoService.setInsertOrderInfo(orderInfo);
        return JsonUtils.map2json(stringObjectMap);
    }
}
