package cn.zzu.service.impl;

import cn.zzu.dao.GoodsInfoDao;
import cn.zzu.dao.OrderGoodsDao;
import cn.zzu.dao.OrderInfoDao;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.OrderGoods;
import cn.zzu.entity.OrderInfo;
import cn.zzu.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private OrderGoodsDao orderGoodsDao;

    @Autowired
    private GoodsInfoDao goodsInfoDao;
    /**
     * 生成订单信息
     * @param orderInfo
     * @return
     */
    @Override
    public Map<String,Object> setInsertOrderInfo(OrderInfo orderInfo) {
        Map<String,Object> result = new HashMap<>();
        if(orderInfo == null){
            result.put("msg",0);
            return result;
        }
        int i = orderInfoDao.insertOrderInfo(orderInfo);
        Integer OrderId = orderInfo.getOrderId();
        System.out.println("我是i数据"+OrderId);
        if(i < 1){
            result.put("msg",0);
            return result;
        }
        result.put("msg",1);
        result.put("OrderId",OrderId);
        return result;
    }

    @Override
    public Map<String, Object> getOrderInfoByOrderId(Integer orderId) {
        OrderInfo orderInfo = orderInfoDao.getOrderInfoByOrderId(orderId);
        List<OrderGoods> orderGoods = orderGoodsDao.getOrderGoodsByOrderId(orderId);
        List<GoodsInfo> goodsInfos = new ArrayList<>();
        for(int i=0;i<orderGoods.size();i++){
            GoodsInfo goodsInfoById = goodsInfoDao.getGoodsInfoById(orderGoods.get(i).getGoodsId());
            goodsInfos.add(goodsInfoById);
        }
        Map<String,Object> result = new HashMap<>();
        result.put("orderInfo",orderInfo);
        result.put("orderGoods",orderGoods);
        result.put("goodsInfos",goodsInfos);
        return result;
    }
}
