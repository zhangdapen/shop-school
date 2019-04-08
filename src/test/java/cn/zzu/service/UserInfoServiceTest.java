package cn.zzu.service;

import cn.zzu.base.BaseTest;
import cn.zzu.entity.PermissionInfo;
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
        int i = userInfoService.insertUserInfo(userInfo);
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
    @Ignore
    public void testGetSelectUserInfoAll(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        UserInfo user = userInfoService.getSelectUserInfoAll(userInfo);
        System.out.println(user);
    }


    @Test
    public void testSetInsertPermissionInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        PermissionInfo permissionInfo=new PermissionInfo();
        permissionInfo.setApplicaId(userInfo.getUserId());
        permissionInfo.setApplicaDes("俺想要称为管理员");
        permissionInfo.setApplicaState("0");
        permissionInfo.setApplicaType("0");
        permissionInfo.setCreateTime(new Date());
        int result = userInfoService.setInsertPermissionInfo(permissionInfo);
        System.out.println(result);
    }

    @Test
    public void testSetUpdateForgetPassword(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(5);
        userInfo.setUserQuestion("你的父亲的名字");
        userInfo.setUserAnswer("罗大锤");
        userInfo.setUserPassword("ilch");
        int i = userInfoService.setUpdateForgetPassword(userInfo);
        System.out.println(i);
    }
}
