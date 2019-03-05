package cn.zzu.dao;

import cn.zzu.base.BaseTest;
import cn.zzu.entity.UserInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * UserInfoDao测试类
 *
 * @author silence
 * @create 2019-02-22-12:28
 */
public class UserInfoDaoTest extends BaseTest {


    @Autowired
    private UserInfoDao userInfoDao;


    @Test
    @Ignore
    public void testSelectUserInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("张三");
        userInfo.setUserPassword("123456");
        UserInfo user = userInfoDao.selectUserInfo(userInfo);
        System.out.println(user);
    }

    @Test
    @Ignore
    public void testInsertUserInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("程浩");
        userInfo.setUserPassword("ch@19970405");
        userInfo.setSchoolId(12);
        userInfo.setUserDate(new Date());
        int i = userInfoDao.insertUserInfo(userInfo);
        System.out.println(i);
    }

    @Test
    @Ignore
    public void testUpdateUserInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserPassword("zhw123");
        userInfo.setUserNickname("silence");
        userInfo.setUserImage("/home/image");
        userInfo.setUserId(3);
        int i = userInfoDao.updateUserInfo(userInfo);
        System.out.println(i);
    }


    @Test
    public void testSelectUserInfoAll(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        UserInfo user = userInfoDao.selectUserInfoAll(userInfo);
        System.out.println(user);
    }
}
