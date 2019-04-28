package cn.zzu.service.impl;

import cn.zzu.dao.UserAddrDao;
import cn.zzu.entity.UserAddr;
import cn.zzu.service.UserAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 地址service
 *
 * @author silence
 * @create 2019-04-22-22:11
 */
@Service
public class UserAddrServiceImpl implements UserAddrService {

    @Autowired
    private UserAddrDao userAddrDao;


    @Override
    public int setUserAddrByUserId(UserAddr userAddr) {
        return userAddrDao.setUserAddrByUserId(userAddr);
    }
}
