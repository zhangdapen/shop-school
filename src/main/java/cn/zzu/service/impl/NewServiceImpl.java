package cn.zzu.service.impl;

import cn.zzu.dao.NewDao;
import cn.zzu.dao.UserAddrDao;
import cn.zzu.entity.News;
import cn.zzu.entity.UserAddr;
import cn.zzu.service.NewService;
import cn.zzu.service.UserAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<News> getNewsByUserId(Integer userId) {
        return newDao.getNewsByUserId(userId);
    }
}
