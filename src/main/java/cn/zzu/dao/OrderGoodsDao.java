package cn.zzu.dao;


import cn.zzu.entity.OrderGoods;

import java.util.List;

public interface OrderGoodsDao {


    /**
     *  插入订单商品
     * @param orderGoods
     * @return
     */
    int insertOrderGoods(OrderGoods orderGoods);

    /**
     * 获取订单中的商品信息
     * @param OrderId
     * @return
     */
    List<OrderGoods> getOrderGoodsByOrderId(Integer OrderId);

}