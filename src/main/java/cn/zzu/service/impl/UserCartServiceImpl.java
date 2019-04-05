package cn.zzu.service.impl;

/**
 * 购物车实现类
 *
 * @author silence
 * @create 2019-03-28-10:29
 */

import cn.zzu.dao.UserCartDao;
import cn.zzu.entity.UserCart;
import cn.zzu.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 购物车service实现类
 */
@Service
public class UserCartServiceImpl implements UserCartService {


    @Autowired
    private UserCartDao userCartDao;


    /**
     * 添加商品到购物车
     * @param userCart  购物车类
     * @return
     */
    @Override
    public int setInsertUserCartInfo(UserCart userCart) {
        return userCartDao.insertUserCartInfo(userCart);
    }


    /**
     * 删除单个商品
     * @param userCart
     * @return
     */
    @Override
    public int setDeleteUserCartInfo(UserCart userCart) {
        return userCartDao.deleteUserCartInfo(userCart);
    }


    /**
     * 清空购物车
     * @param userCart
     * @return
     */
    @Override
    public int setDeleteUserCartInfoAll(UserCart userCart) {
        return userCartDao.deleteUserCartInfoAll(userCart);
    }


    /**
     * 获取用户购物车中的商品信息
     * @param userId
     * @return
     */
    @Override
    public Map<Integer, UserCart> getSelectUserCarInfo(Integer userId) {
        return userCartDao.selectUserCarInfo(userId);
    }


}
