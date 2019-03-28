package cn.zzu.dao;

import cn.zzu.entity.UserCart;

/**
 * 购物车
 */
public interface UserCartDao {

    /**
     * 添加商品到购物车（user——cart的insert操作）
     * @param userCart
     * @return
     */
    int insertUserCartInfo(UserCart userCart);

    /**
     * (删除单件商品：逻辑删除，把状态设为1)
     * @return
     */
    int deleteUserCartInfo(UserCart userCart);


    /**
     * 根据用户Id清除购物车
     *
     * @return
     */
    int deleteUserCartInfoAll(UserCart userCart);
}