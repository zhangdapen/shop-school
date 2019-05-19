package cn.zzu.service.impl;

import cn.zzu.dao.AdDao;
import cn.zzu.dao.CollDao;
import cn.zzu.entity.Ad;
import cn.zzu.entity.Coll;
import cn.zzu.service.AdService;
import cn.zzu.service.CollService;
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
public class AdServiceimpl implements AdService {

    @Autowired
    private AdDao adDao;

    @Override
    public Map<String, Object> getAd() {
        Map<String,Object> result = new HashMap<>();
        List<Ad> ad = adDao.getAd();
        if(ad.size() == 0){
            result.put("msg",1);
            return result;
        }
        result.put("ad",ad);
        result.put("msg",1);
        return result;
    }

    @Override
    public Map<String, Object> setAd(Ad ad) {
        Map<String,Object> result = new HashMap<>();
        if(ad==null){
            result.put("msg","参数为空");
            return result;
        }
        int i = adDao.setAd(ad);
        result.put("msg",i);
        return result;
    }

    @Override
    public Map<String, Object> deleteAdById(Integer adId) {
        Map<String,Object> result = new HashMap<>();
        if(adId == null){
            result.put("msg","参数为空");
            return result;
        }
        int i = adDao.deleteAdById(adId);
        result.put("msg","删除成功");
        result.put("res",i);
        return result;
    }
}
