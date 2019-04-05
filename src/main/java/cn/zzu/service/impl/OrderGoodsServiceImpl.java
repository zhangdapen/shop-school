package cn.zzu.service.impl;

import cn.zzu.dao.OrderGoodsDao;
import cn.zzu.entity.OrderGoods;
import cn.zzu.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单商品的service实现类
 *
 * @author silence
 * @create 2019-04-02-16:17
 */
@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {


    @Autowired
    private OrderGoodsDao orderGoodsDao;
    /**
     * 直接购买商品
     * @param orderGoods
     * @return
     */
    @Override
    public int setInsertOrderGoods(OrderGoods orderGoods) {
        return orderGoodsDao.insertOrderGoods(orderGoods);
    }
}
