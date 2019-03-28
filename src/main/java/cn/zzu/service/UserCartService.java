package cn.zzu.service;

import cn.zzu.entity.UserCart;

/**
 * 购物车service
 */
public interface UserCartService {

    /**
     * 添加购物车
     * @param userCart  购物车类
     * @return
     */
    int setInsertUserCartInfo(UserCart userCart);

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
}
