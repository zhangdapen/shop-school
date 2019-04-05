package cn.zzu.service;

import cn.zzu.entity.OrderInfo;

public interface OrderInfoService {


    /**
     * 生成订单信息
     * @param orderInfo
     * @return
     */
    int setInsertOrderInfo(OrderInfo orderInfo);
}
