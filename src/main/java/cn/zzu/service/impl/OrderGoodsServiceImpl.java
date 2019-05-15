package cn.zzu.service.impl;

import cn.zzu.dao.OrderGoodsDao;
import cn.zzu.entity.OrderGoods;
import cn.zzu.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param
     * @return
     */
    @Override
    public Map<String,Object> setInsertOrderGoods(List<OrderGoods> orderGoods) {
        Map<String,Object> result = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if(orderGoods.size() == 0){
            result.put("msg",0);
            return result;
        }
        for(int i=0;i<orderGoods.size();i++){

            int i1 = orderGoodsDao.insertOrderGoods(orderGoods.get(i));
            list.add(i1);
        }
        int r=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i) != 1){
               r++;
            }
        }
        if(r!=0){
            result.put("msg",0);
            return result;
        }
        result.put("msg",1);
        return result;


    }
}
