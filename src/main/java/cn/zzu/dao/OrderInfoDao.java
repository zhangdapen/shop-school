package cn.zzu.dao;


import cn.zzu.entity.OrderInfo;

/**
 * 订单信息表
 */
public interface OrderInfoDao {

    /**
     * 生成订单信息
     * @param orderInfo
     * @return
     */
    int insertOrderInfo(OrderInfo orderInfo);
}