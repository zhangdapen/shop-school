package cn.zzu.service;

import cn.zzu.base.BaseTest;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.OrderGoods;
import cn.zzu.entity.PermissionInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * GoodsInfoserviceTest测试类
 *
 * @author silence
 * @create 2019-02-22-13:16
 */
public class OrderGoodsServiceTest extends BaseTest {

    @Autowired
    private OrderGoodsService orderGoodsService;


    @Test
    public void testsetInsertOrderGoods(){
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setCreateTime(new Date());
        orderGoods.setOrderId(3);
        orderGoods.setGoodsId(13);
        int i = orderGoodsService.setInsertOrderGoods(orderGoods);
        System.out.println(i);
    }
}
