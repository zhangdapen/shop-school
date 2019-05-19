package cn.zzu.service;


import cn.zzu.entity.Ad;

import java.util.Map;

/**
 * 广告service
 */
public interface AdService {

    Map<String,Object> getAd();

    Map<String,Object> setAd(Ad ad);

    Map<String,Object> deleteAdById(Integer adId);
}
