package cn.zzu.service.impl;

import cn.zzu.dao.AdDao;
import cn.zzu.dao.SchoolInfoDao;
import cn.zzu.dao.UserAddrDao;
import cn.zzu.dao.UserInfoDao;
import cn.zzu.entity.*;
import cn.zzu.service.AdService;
import cn.zzu.service.InfoService;
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
public class InfoServiceimpl implements InfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private SchoolInfoDao schoolInfoDao;

    @Autowired
    private UserAddrDao userAddrDao;

    @Override
    public Map<String, Object> getInfo(UserInfo userInfo) {
        Integer userId = userInfo.getUserId();
        Integer schoolId;
        Map<String,Object> result = new HashMap<>();
        UserInfo userInfoByUserId = userInfoDao.getUserInfoByUserId(userId);
        schoolId=userInfoByUserId.getSchoolId();
        SchoolInfo schoolInfoBySchoolId = schoolInfoDao.getSchoolInfoBySchoolId(schoolId);
        List<UserAddr> userAddrByUserId = userAddrDao.getUserAddrByUserId(userId);
        if (userInfoByUserId==null || schoolInfoBySchoolId ==null || userAddrByUserId.size()==0){
            result.put("msg",0);
        }
        result.put("msg",1);
        result.put("user",userInfoByUserId);
        result.put("school",schoolInfoBySchoolId);
        result.put("addr",userAddrByUserId);
        return result;
    }
}
