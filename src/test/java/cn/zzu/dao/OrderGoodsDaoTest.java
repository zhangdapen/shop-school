package cn.zzu.dao;

import cn.zzu.base.BaseTest;
import cn.zzu.entity.OrderGoods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 订单测试类
 *
 * @author silence
 * @create 2019-03-28-16:31
 */
public class OrderGoodsDaoTest extends BaseTest {

    @Autowired
    private OrderGoodsDao orderGoodsDao;



    @Test
    public void testInsertOrderGoods(){
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setCreateTime(new Date());
        orderGoods.setOrderId(2);
        orderGoods.setGoodsId(13);
        int i = orderGoodsDao.insertOrderGoods(orderGoods);
        System.out.println(i);
    }

}
