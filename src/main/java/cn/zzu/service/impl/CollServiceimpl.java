package cn.zzu.service.impl;

import cn.zzu.dao.CollDao;
import cn.zzu.entity.Coll;
import cn.zzu.service.CollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * GoodsInfo的service实现类
 *
 * @author silence
 * @create 2019-02-22-13:14
 */
@Service
public class CollServiceimpl implements CollService {

    @Autowired
    private CollDao collDao;

    @Override
    public Map<String, Object> setColl(Coll coll) {
        Map<String,Object> result = new HashMap<>();
        int i = collDao.setColl(coll);
        if(i<=0){
            result.put("msg",0);
            return result;
        }
        result.put("msg",i);
        return result;
    }


    /**
     * 更新收藏信息
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> updateColl(Integer id) {
        Map<String,Object> result =new HashMap<>();
        int i = collDao.updateColl(id);
        if(i<1){
            result.put("msg",0);
            return result;
        }
        result.put("msg",1);
        return result;
    }
}
