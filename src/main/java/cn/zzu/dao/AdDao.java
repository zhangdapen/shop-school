package cn.zzu.dao;


import cn.zzu.entity.Ad;

import java.util.List;

public interface AdDao {

    List<Ad> getAd();

    int setAd(Ad ad);

    int deleteAdById(Integer adId);
}