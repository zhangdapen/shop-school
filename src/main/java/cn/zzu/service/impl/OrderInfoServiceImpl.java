package cn.zzu.service.impl;

import cn.zzu.dao.OrderInfoDao;
import cn.zzu.entity.OrderInfo;
import cn.zzu.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单信息service实现类
 *
 * @author silence
 * @create 2019-04-02-18:31
 */

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;

    /**
     * 生成订单信息
     * @param orderInfo
     * @return
     */
    @Override
    public int setInsertOrderInfo(OrderInfo orderInfo) {
        return orderInfoDao.insertOrderInfo(orderInfo);
    }
}
