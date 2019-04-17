package cn.zzu.service.user;

import cn.zzu.entity.UserInfo;
import cn.zzu.execption.MyExecption;

import java.util.Map;


public interface UserService {
    Map<String,Object> login(String userName,String password) throws MyExecption;
    Map<String,Object> register(UserInfo userInfo) throws MyExecption;
    Map<String,Object> isRepeat(String username) throws MyExecption;
    Map<String,Object> isAnswer(String userName,String userAnswer,String userQuestion) throws MyExecption;
    Map<String,Object> findPassword(String userName,String userPassword) throws  MyExecption;
}
