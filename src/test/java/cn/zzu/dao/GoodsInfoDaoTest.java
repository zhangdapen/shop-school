package cn.zzu.dao;

import cn.zzu.base.BaseTest;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.PermissionInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 商品操作dao的测试类
 *
 * @author silence
 * @create 2019-03-15-16:37
 */
public class GoodsInfoDaoTest extends BaseTest {

    @Autowired
    private GoodsInfoDao goodsInfoDao;


    @Test
    public void testInsertGoodsInfo(){
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodsName("肥仔快乐水");
        goodsInfo.setGoodsDes("能够令肥宅快乐的东西");
        goodsInfo.setGoodsImage("/home/image");
        goodsInfo.setUserId(1);
        goodsInfo.setSchoolId(1);
        goodsInfo.setGoodsPrice(2.5);
        goodsInfo.setCategoryId(1);
        goodsInfo.setGoodsState(0);
        goodsInfo.setCreateTime(new Date());
        int i = goodsInfoDao.insertGoodsInfo(goodsInfo);
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setApplicaId(goodsInfo.getGoodsId());
        permissionInfo.setApplicaType("商品");
        permissionInfo.setApplicaDes("我想要发布商品");
        permissionInfo.setApplicaState("0");
        permissionInfo.setCreateTime(new Date());
        int j = goodsInfoDao.insertPermissionGoodsInfo(permissionInfo);
        System.out.println("i="+i);
        System.out.println("j="+j);
    }

}
