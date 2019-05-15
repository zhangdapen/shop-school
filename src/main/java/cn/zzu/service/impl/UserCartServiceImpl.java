package cn.zzu.service.impl;

/**
 * 购物车实现类
 *
 * @author silence
 * @create 2019-03-28-10:29
 */

import ch.qos.logback.classic.Logger;
import cn.zzu.controller.UserInfoController;
import cn.zzu.dao.GoodsInfoDao;
import cn.zzu.dao.UserCartDao;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.UserCart;
import cn.zzu.service.UserCartService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 购物车service实现类
 */
@Service
public class UserCartServiceImpl implements UserCartService {


    @Autowired
    private UserCartDao userCartDao;

    @Autowired
    private GoodsInfoDao goodsInfoDao;


    Logger logger = (Logger) LoggerFactory.getLogger(UserCartServiceImpl.class);

    /**
     * 添加商品到购物车
     * @param userCart  购物车类
     * @return
     */
    @Override
    public Map<String,Object> setInsertUserCartInfo(UserCart userCart) {
        Map<String,Object> result =new HashMap<>();
        logger.debug("添加商品到购物车逻辑开始");
        int i = userCartDao.insertUserCartInfo(userCart);
        logger.debug("操作结果"+i);
        if (i<1){
            result.put("msg",0);
            return result;
        }
        result.put("msg",i);
        return result;
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
    public Map<String,Object> getSelectUserCarInfo(Integer userId) {
        List<UserCart> userCarts = userCartDao.selectUserCarInfo(userId);
        Iterator<UserCart> it = userCarts.iterator();
        List<Integer> id = new ArrayList<>();
        List<GoodsInfo> goods = new ArrayList<>();
        while(it.hasNext()){
            UserCart userCart = it.next();
            Integer goodsId = userCart.getGoodsId();
            id.add(goodsId);
        }
        System.out.println(id.toString());
        //获取商品信息
        for(int i=0;i<id.size();i++){
            GoodsInfo goodsInfo = goodsInfoDao.getGoodsInfoById(id.get(i));
            goods.add(goodsInfo);
        }
        System.out.println(goods.toString());
        int size = userCarts.size();
        Map<String,Object> result = new HashMap<>();
        result.put("size",size);
        result.put("car",userCarts);
        result.put("goods",goods);
        result.put("msg",1);
        result.put("goodsIds",id);
        return result;
    }


}
