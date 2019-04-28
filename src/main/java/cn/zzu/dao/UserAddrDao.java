package cn.zzu.dao;


import cn.zzu.entity.UserAddr;

import java.util.List;

public interface UserAddrDao {

    /**
     * 根据userid获取地址
     * @param userId
     * @return
     */
    List<UserAddr> getUserAddrByUserId(Integer userId);

    /**
     * 添加地址
     * @param userAddr
     * @return
     */
    int setUserAddrByUserId(UserAddr userAddr);
}