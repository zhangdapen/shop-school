package cn.zzu.service;

import cn.zzu.entity.UserCart;

import java.util.List;
import java.util.Map;

/**
 * 购物车service
 */
public interface UserCartService {

    /**
     * 添加购物车
     * @param userCart  购物车类
     * @return
     */
    Map<String,Object> setInsertUserCartInfo(UserCart userCart);

    /**
     * 删除单个商品
     * @param userCart
     * @return
     */
    int setDeleteUserCartInfo(UserCart userCart);

    /**
     * 清除购物车
     * @param userCart
     * @return
     */
    int setDeleteUserCartInfoAll(UserCart userCart);

    /**
     * 获取用户购物车中的所有商品
     * @param userId
     * @return
     */
    Map<String,Object> getSelectUserCarInfo(Integer userId);
}
