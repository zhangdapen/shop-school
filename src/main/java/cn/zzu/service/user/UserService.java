package cn.zzu.service.user;

import cn.zzu.entity.UserInfo;
import cn.zzu.execption.MyExecption;

import java.util.Map;


public interface UserService {
    Map<String,Object> login(String userName,String password) throws MyExecption;
    Map<String,Object> register(UserInfo userInfo) throws MyExecption;


}
