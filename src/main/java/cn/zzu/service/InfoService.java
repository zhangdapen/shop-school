package cn.zzu.service;


import cn.zzu.entity.UserInfo;

import java.util.Map;

/**
 * 广告service
 */
public interface InfoService {

    Map<String,Object> getInfo(UserInfo userInfo);

}
