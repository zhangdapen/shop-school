package cn.zzu.service;

import cn.zzu.base.BaseTest;
import cn.zzu.entity.UserInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * UserInfoService测试类
 *
 * @author silence
 * @create 2019-02-22-13:16
 */
public class UserInfoServiceTest extends BaseTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    @Ignore
    public void testGetSelectUserInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("张三");
        userInfo.setUserPassword("123456");
        UserInfo user = userInfoService.getSelectUserInfo(userInfo);
        System.out.println(user);
    }

    @Test
    @Ignore
    public void testSetInsertUserInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("张宏伟");
        userInfo.setUserPassword("zhw@19970607");
        userInfo.setSchoolId(2);
        userInfo.setUserDate(new Date());
        int i = userInfoService.setInsertUserInfo(userInfo);
        System.out.println(i);
    }

    @Test
    @Ignore
    public void testSetUpdateUserInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserPassword("zhw@19970607");
        userInfo.setUserId(3);
        int i = userInfoService.setUpdateUserInfo(userInfo);
        System.out.println(i);
    }

    @Test
    public void testGetSelectUserInfoAll(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        UserInfo user = userInfoService.getSelectUserInfoAll(userInfo);
        System.out.println(user);
    }

}
