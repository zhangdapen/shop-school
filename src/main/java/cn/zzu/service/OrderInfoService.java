package cn.zzu.service;

import cn.zzu.entity.OrderInfo;

import java.util.Map;

public interface OrderInfoService {


    /**
     * 生成订单信息
     * @param orderInfo
     * @return
     */
    Map<String,Object> setInsertOrderInfo(OrderInfo orderInfo);


    /**
     * 根据id获取订单信息
     * @param orderId
     * @return
     */
    Map<String,Object> getOrderInfoByOrderId(Integer orderId);
}
