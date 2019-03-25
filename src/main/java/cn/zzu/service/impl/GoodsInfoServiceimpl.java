package cn.zzu.service.impl;

import cn.zzu.dao.GoodsInfoDao;
import cn.zzu.dao.UserInfoDao;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.entity.UserInfo;
import cn.zzu.service.GoodsInfoService;
import cn.zzu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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



    @Override
    public int setInsertGoodsInfo(GoodsInfo goodsInfo) {
        return goodsInfoDao.insertGoodsInfo(goodsInfo);
    }

    @Override
    public int setInsertPermissionGoodsInfo(PermissionInfo permissionInfo) {
        return goodsInfoDao.insertPermissionGoodsInfo(permissionInfo);
    }
}
