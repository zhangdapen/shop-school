package cn.zzu.service.impl;

import cn.zzu.dao.GoodsInfoDao;
import cn.zzu.entity.GoodsInfo;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.service.GoodsInfoService;
import cn.zzu.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 获取商品信息
     * @return
     */
    @Override
    public Map<String, Object> getGoodsInfo() {
        Map<String,Object> result = new HashMap<>();
        List<GoodsInfo> goodsInfo = goodsInfoDao.getGoodsInfo();
        if(goodsInfo.size() == 0){
            result.put("msg",0);
            return result;
        }
        result.put("msg",1);
        result.put("goods",goodsInfo);
        result.put("size",goodsInfo.size());
        return result;
    }


    /**
     * 根据categoryId获取商品信息
     * @param categoryId
     * @return
     */
    @Override
    public Map<String, Object> getGoodsInfoByCategory(Integer categoryId) {
        Map<String,Object> result = new HashMap<>();
        List<GoodsInfo> goodsInfoByCategory = goodsInfoDao.getGoodsInfoByCategory(categoryId);
        if(goodsInfoByCategory == null){
            result.put("msg0",0);
            return result;
        }
        result.put("goodsC",goodsInfoByCategory);
        result.put("msg",1);
        result.put("size",goodsInfoByCategory.size());
        return result;
    }

    /**
     * 根据goodsId获取商品信息
     * @param goodsId
     * @return
     */
    @Override
    public Map<String,Object> getGoodsInfoByGoodsId(Integer goodsId) {
        Map<String,Object> result = new HashMap<>();
        GoodsInfo goodsInfoById = goodsInfoDao.getGoodsInfoById(goodsId);
        if(goodsInfoById == null){
            result.put("msg",0);
            return result;
        }
        result.put("goodsInfo",goodsInfoById);
        result.put("msg",1);
        return result;
    }
}
