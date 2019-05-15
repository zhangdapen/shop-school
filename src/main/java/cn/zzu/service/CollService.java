package cn.zzu.service;

import cn.zzu.entity.Coll;
import cn.zzu.entity.UserCart;

import java.util.Map;

/**
 * 购物车service
 */
public interface CollService {


    /**
     * 设置收藏
     * @param coll
     * @return
     */
    Map<String,Object> setColl(Coll coll);


    /**
     * 更新收藏
     * @param id
     * @return
     */
    Map<String,Object> updateColl(Integer id);

}
