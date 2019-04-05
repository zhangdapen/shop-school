package cn.zzu.service;

import cn.zzu.base.BaseTest;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.entity.UserInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * GoodsInfoserviceTest测试类
 *
 * @author silence
 * @create 2019-02-22-13:16
 */
public class GoodsInfoServiceTest extends BaseTest {

    @Autowired
    private GoodsInfoService goodsInfoService;


    @Test
    @Ignore
    public void testSetInsertGoodsInfo(){
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodsName("乐事");
        goodsInfo.setGoodsDes("能够令肥宅快乐的薯片");
        goodsInfo.setGoodsImage("/home/image");
        goodsInfo.setUserId(1);
        goodsInfo.setSchoolId(1);
        goodsInfo.setGoodsPrice(5.0);
        goodsInfo.setCategoryId(1);
        goodsInfo.setGoodsState(0);
        goodsInfo.setCreateTime(new Date());
        int i = goodsInfoService.setInsertGoodsInfo(goodsInfo);
        PermissionInfo permissionInfo = new PermissionInfo();
        System.out.println(goodsInfo.getGoodsId());
        permissionInfo.setApplicaId(goodsInfo.getGoodsId());
        permissionInfo.setApplicaType("商品");
        permissionInfo.setApplicaDes("我想要发布商品");
        permissionInfo.setApplicaState("0");
        permissionInfo.setCreateTime(new Date());
        int j = goodsInfoService.setInsertPermissionGoodsInfo(permissionInfo);
        System.out.println("i="+i);
        System.out.println("j="+j);
    }


    @Test
    public void testGetSelectGoodsInfoPrice(){
        Double price = goodsInfoService.getSelectGoodsInfoPrice(11);
        System.out.println(price);
    }
}
