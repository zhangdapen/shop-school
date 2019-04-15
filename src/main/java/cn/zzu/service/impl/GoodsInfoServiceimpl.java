package cn.zzu.service.impl;

import cn.zzu.dao.GoodsInfoDao;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * GoodsInfo的service实现类
 *
 * @author silence
 * @create 2019-02-22-13:14
 */
@Service
public class GoodsInfoServiceimpl implements GoodsInfoService {

    @Autowired
    private GoodsInfoDao goodsInfoDao;


    /**
     * 发布商品
     * @param goodsInfo
     * @return
     */
    @Override
    public int setInsertGoodsInfo(GoodsInfo goodsInfo) {
        return goodsInfoDao.insertGoodsInfo(goodsInfo);
    }


    /**
     * 发布商品申请
     * @param permissionInfo
     * @return
     */
    @Override
    public int setInsertPermissionGoodsInfo(PermissionInfo permissionInfo) {
        return goodsInfoDao.insertPermissionGoodsInfo(permissionInfo);
    }


    /**
     * 获取商品价格
     * @param goodsId
     * @return
     */
    @Override
    public Double getSelectGoodsInfoPrice(Integer goodsId) {
        return goodsInfoDao.selectGoodsInfoPrice(goodsId);
    }
}
