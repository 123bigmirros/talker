package com.daydayboom.Service.UserService;

import com.daydayboom.Bean.Message;
import com.daydayboom.Bean.Userdata.User;

import javax.websocket.Session;
import java.io.IOException;

public interface UserServiceImp {
    public void service(Session s, Message message) throws Exception;
    //用于判断该用户是否已经注册
    public User has_user(String Phone);
    //登陆和注册集成在一个方法中
    public void logOrreg(Session s,Message message) throws Exception;
    //获取用户数据
    public void getUserdata(Session s,Message message) throws Exception;
    //改变用户数据
    public void changeUserData(Session s,Message message) throws Exception;
    //通过ID获得用户
    public void getUserName(Session s,Message message) throws Exception;
}
