package cn.zzu.service;

import cn.zzu.entity.OrderGoods;

import java.util.List;
import java.util.Map;

public interface OrderGoodsService {

    Map<String,Object> setInsertOrderGoods(List<OrderGoods> orderGoods);
}
