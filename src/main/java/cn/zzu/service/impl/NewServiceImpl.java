package cn.zzu.service.impl;

import cn.zzu.dao.NewDao;
import cn.zzu.dao.UserAddrDao;
import cn.zzu.dao.UserInfoDao;
import cn.zzu.entity.News;
import cn.zzu.entity.UserAddr;
import cn.zzu.entity.UserInfo;
import cn.zzu.service.NewService;
import cn.zzu.service.UserAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 帖子service
 *
 * @author silence
 * @create 2019-04-22-22:11
 */
@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private NewDao newDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<News> getNewsByUserId(Integer userId) {
        return newDao.getNewsByUserId(userId);
    }

    @Override
    public Map<String, Object> getNews() {
        List<News> news = newDao.getNews();
        List<String> nick=new ArrayList<>();
        for(int i=0;i<news.size();i++){
            Integer userId = news.get(i).getUserId();
            String userNickname = userInfoDao.getUserInfoByUserId(userId).getUserNickname();
            nick.add(userNickname);
        }
        Map<String,Object> result = new HashMap<>();
        if(news.size()>0){
            result.put("msg",1);
            result.put("news",news);
            result.put("nick",nick);
            return result;
        }
        result.put("msg",0);
        return result;
    }
}
