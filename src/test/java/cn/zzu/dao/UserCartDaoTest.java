package cn.zzu.dao;

import cn.zzu.base.BaseTest;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.UserCart;
import cn.zzu.entity.UserInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 购物车测试类
 *
 * @author silence
 * @create 2019-03-26-19:41
 */
public class UserCartDaoTest extends BaseTest {

    @Autowired
    private UserCartDao userCartDao;

    @Test
    @Ignore
    public void testInsertUserCartInfo(){

        UserCart userCart= new UserCart();
        UserInfo userInfo= new UserInfo();
        GoodsInfo goodsInfo=new GoodsInfo();
        userInfo.setUserId(1);
        goodsInfo.setGoodsId(14);
        userCart.setUserId(userInfo.getUserId());
        userCart.setGoodsId(goodsInfo.getGoodsId());
        userCart.setCreateTime(new Date());
        int i = userCartDao.insertUserCartInfo(userCart);
        System.out.println(i);
    }

    @Test
    @Ignore
    public void testDeleteUserCartInfo(){
        UserCart userCart= new UserCart();
        userCart.setCartId(4);
        userCart.setUpdateTime(new Date());
        int i = userCartDao.deleteUserCartInfo(userCart);
        System.out.println(i);

    }

    @Test
    @Ignore
    public void testDeleteUserCartInfoAll(){
        UserInfo userInfo = new UserInfo();
        UserCart userCart= new UserCart();
        userInfo.setUserId(5);
        userCart.setUserId(userInfo.getUserId());
        userCart.setUpdateTime(new Date());
        int i = userCartDao.deleteUserCartInfoAll(userCart);
        System.out.println(i);
    }


    @Test
    public void testSelectUserCarInfo(){
        Map<Integer, UserCart> userCartMap = userCartDao.selectUserCarInfo(1);
        Set<Integer> integers = userCartMap.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while(iterator.hasNext()){
            System.out.println(userCartMap.get(iterator.next()).toString());
        }
    }
}
