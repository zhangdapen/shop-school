package cn.zzu.dao;

import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.PermissionInfo;

public interface GoodsInfoDao {


    /**
     * 发布商品  先插入到申请表中
     * @param permissionInfo
     * @return
     */
    int insertPermissionGoodsInfo(PermissionInfo permissionInfo);


    /**
     * 添加商品信息，，但是状态设置为0，审核为通过
     * @param goodsInfo
     * @return
     */
    int insertGoodsInfo(GoodsInfo goodsInfo);


}