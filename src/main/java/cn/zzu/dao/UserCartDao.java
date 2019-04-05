package cn.zzu.dao;

import cn.zzu.entity.UserCart;
import org.apache.ibatis.annotations.MapKey;

import java.util.Map;

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


    /**
     * 查询用户购物车中的所有商品
     * @param userId
     * @return
     */
    @MapKey("cartId")
    Map<Integer,UserCart> selectUserCarInfo(Integer userId);
}