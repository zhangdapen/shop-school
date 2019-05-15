package cn.zzu.dao;

import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.PermissionInfo;

import java.util.List;

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


    /**
     * 获取商品的价格
     * @param goodsId
     * @return
     */
    Double selectGoodsInfoPrice(Integer goodsId);


    /**
     * 根据商品id获取商品信息
     * @param goodsId
     * @return
     */
    GoodsInfo getGoodsInfoById(Integer goodsId);

    /**
     * 获取所有商品信息
     * @return
     */
    List<GoodsInfo> getGoodsInfo();


    /**
     * 根据categoryId查询商品信息
     * @param id
     * @return
     */
    List<GoodsInfo> getGoodsInfoByCategory(Integer id);


    /**
     * 根据goodsId获取商品信息
     * @param goodsId
     * @return
     */
    GoodsInfo getGoodsInfoByGoodsId(Integer goodsId);
}