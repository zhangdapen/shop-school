package cn.zzu.service;

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
 * @create 2019-03-28-10:32
 */
public class UserCartServiceTest extends BaseTest {

    @Autowired
    private UserCartService userCartService;


    @Test
    @Ignore
    public void testSetInsertUserCartInfo(){
        UserCart userCart = new UserCart();
        UserInfo userInfo = new UserInfo();
        GoodsInfo goodsInfo = new GoodsInfo();
        userInfo.setUserId(5);
        goodsInfo.setGoodsId(13);
        userCart.setUserId(userInfo.getUserId());
        userCart.setGoodsId(goodsInfo.getGoodsId());
        userCart.setCreateTime(new Date());
        int i = userCartService.setInsertUserCartInfo(userCart);
        System.out.println(i);
    }

    @Test
    @Ignore
    public void testSetDeleteUserCartInfo(){
        UserCart userCart = new UserCart();
        userCart.setCartId(5);
        userCart.setUpdateTime(new Date());
        int i = userCartService.setDeleteUserCartInfo(userCart);
        System.out.println(i);
    }

    @Test
    @Ignore
    public void testSetDeleteUserCartInfoAll(){
        UserCart userCart = new UserCart();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1);
        userCart.setUpdateTime(new Date());
        userCart.setUserId(userInfo.getUserId());
        int i = userCartService.setDeleteUserCartInfoAll(userCart);
        System.out.println(i);
    }

    @Test
    public void testGetSelectUserCarInfo(){
        Map<Integer, UserCart> map = userCartService.getSelectUserCarInfo(1);
        Set<Integer> keys = map.keySet();
        Iterator<Integer> it = keys.iterator();
        while(it.hasNext()){
            Integer key=it.next();
            System.out.println(key);
            System.out.println(map.get(key).toString());
        }
    }
}
