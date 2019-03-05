package cn.zzu.dao;

import cn.zzu.entity.OrderGoods;

public interface OrderGoodsMapper {
    int deleteByPrimaryKey(Integer orderGoodsId);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    OrderGoods selectByPrimaryKey(Integer orderGoodsId);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);
}