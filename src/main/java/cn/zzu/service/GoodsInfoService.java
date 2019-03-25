package cn.zzu.service;


import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.PermissionInfo;

public interface GoodsInfoService {

    /**
     * 发布商品
     * @param goodsInfo
     * @return
     */
    int setInsertGoodsInfo(GoodsInfo goodsInfo);


    /**
     * 发布商品申请
     * @param permissionInfo
     * @return
     */
    int setInsertPermissionGoodsInfo(PermissionInfo permissionInfo);
}
