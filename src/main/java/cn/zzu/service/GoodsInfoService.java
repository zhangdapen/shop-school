package cn.zzu.service;


import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.PermissionInfo;

import java.util.Map;

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


    /**
     * 获取商品价格
     * @param goodsId
     * @return
     */
    Double getSelectGoodsInfoPrice(Integer goodsId);


    /**
     * 获取所有商品信息
     * @return
     */
    Map<String,Object> getGoodsInfo();

    /**
     * 根据类别id获取商品信息
     * @return
     */
    Map<String,Object> getGoodsInfoByCategory(Integer categoryId);


    /**
     * 根据goodsId获取商品信息
     * @param goodsId
     * @return
     */
    Map<String,Object> getGoodsInfoByGoodsId(Integer goodsId);
}
