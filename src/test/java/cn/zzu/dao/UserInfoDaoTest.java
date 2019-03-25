package cn.zzu.dao;

import cn.zzu.base.BaseTest;
import cn.zzu.entity.PermissionInfo;
import cn.zzu.entity.UserInfo;
import com.alibaba.fastjson.JSONObject;
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
    public void testSelectUserInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("张三");
        userInfo.setUserPassword("123456");
        UserInfo user = userInfoDao.selectUserInfo(userInfo);
        String s = JSONObject.toJSONString(user);
        System.out.println(user);
        System.out.println(s);
    }

    @Test
    @Ignore
    public void testInsertUserInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("罗玥");
        userInfo.setUserPassword("ly@19970405");
        userInfo.setSchoolId(12);
        userInfo.setUserDate(new Date());
        userInfo.setUserQuestion("你的父亲的名字");
        userInfo.setUserAnswer("罗大锤");
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
    @Ignore
    public void testSelectUserInfoAll(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        UserInfo user = userInfoDao.selectUserInfoAll(userInfo);
        System.out.println(user);
    }

    @Test
    @Ignore
    public void testInsertPermissionInfo(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(4);
        PermissionInfo permissionInfo=new PermissionInfo();
        permissionInfo.setApplicaId(userInfo.getUserId());
        permissionInfo.setApplicaDes("我想要称为管理员");
        permissionInfo.setApplicaType("0");  //0代表管理员
        permissionInfo.setApplicaState("0"); //0代表还没审核通过  1代表通过
        permissionInfo.setCreateTime(new Date());
        int result = userInfoDao.insertPermissionInfo(permissionInfo);
        System.out.println(result);
    }

    @Test
    public void testSelectUserInfoAnswer(){
        UserInfo userInfo= new UserInfo();
        userInfo.setUserId(5);
        userInfo.setUserQuestion("你的父亲的名字");
        userInfo.setUserAnswer("罗大锤");
        UserInfo userInfo1 = userInfoDao.selectUserInfoAnswer(userInfo);
        System.out.println(userInfo1);
    }


    @Test
    public void testUpdateUserInfoPassword(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(1);
        userInfo.setUserPassword("zhw@19970607");
        int i = userInfoDao.updateUserInfoPassword(userInfo);
        System.out.println(i);

    }
}
