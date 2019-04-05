package cn.zzu.dao;


import cn.zzu.entity.OrderGoods;

public interface OrderGoodsDao {


    /**
     *  直接下单购买
     * @param orderGoods
     * @return
     */
    int insertOrderGoods(OrderGoods orderGoods);

}