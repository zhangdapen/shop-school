package cn.zzu.dao;

import cn.zzu.base.BaseTest;
import cn.zzu.entity.OrderGoods;
import cn.zzu.entity.OrderInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 订单测试类
 *
 * @author silence
 * @create 2019-03-28-16:31
 */
public class OrderInfoDaoTest extends BaseTest {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    private GoodsInfoDao goodsInfoDao;

    @Autowired
    private OrderGoodsDao orderGoodsDao;

    @Test
    public void testInsertOrderInfo(){
        //先从OrderGoods中获取商品id
        goodsInfoDao.selectGoodsInfoPrice(2);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderAmount(2.0);
        orderInfo.setCreateTime(new Date());
        orderInfo.setOrderState(0);
        orderInfo.setAddrId(1);
    }

}
