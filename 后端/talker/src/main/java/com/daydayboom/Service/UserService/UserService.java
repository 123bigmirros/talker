package com.daydayboom.Service.UserService;

import com.daydayboom.Bean.Message;
import com.daydayboom.Bean.Range.ListGetRange;
import com.daydayboom.Bean.Userdata.User;
import com.daydayboom.Config.Container;
import com.daydayboom.Instrument.DataChange;
import com.daydayboom.Instrument.SendMessage;
import com.daydayboom.Instrument.SpringUtil;
import com.daydayboom.Service.TalkService.TalkService;
import com.daydayboom.mapper.UserMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.websocket.Session;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@Component
public class UserService implements UserServiceImp {


    static UserMapper userMapper = (UserMapper) SpringUtil.getBean("userMapper");
    static TalkService talkService = (TalkService) SpringUtil.getBean("talkService");
    static RedisTemplate<String,String> redisTemplate = (RedisTemplate<String, String>) SpringUtil.getBean("redisTemplate");
    @Override
    public void service(Session s, Message message) throws Exception {
        if(message.getTypeVariety()== User.LOGIN_REGISTER) logOrreg(s,message);
        else if(message.getTypeVariety() == User.GET_USERDATA)getUserdata(s,message);
        else if(message.getTypeVariety()==User.CHANGE_USERDATA) changeUserData(s,message);
        else if(message.getTypeVariety()==User.GET_USER_NAME) getUserName(s,message);
    }

    @Override
    public User has_user(String Phone) {
        return userMapper.GetByPhone(Phone);
    }
    //将登陆和注册集成在一个方法中
    @Override
    public void logOrreg(Session s, Message message) throws Exception {
        User user = null;
        //判断用户是否存在，如果不存在则调用注册操作
        if((user = has_user(String.valueOf(message.getFrom())))==null){
            user = userMapper.register(new User(message.getContent()));
        }
        //将用户账户和器对应的session绑定
        Container.bind(s,user);
        SendMessage.responseMessage(s,message,(Object) user,true);
        talkService.getMessage(s,user);
    }

    @Override
    public void getUserdata(Session s, Message message) throws Exception {
        User user = userMapper.GetById(message.getTo());
        SendMessage.responseMessage(s,message,(Object) user,true);
    }

    @Override
    public void changeUserData(Session s, Message message) throws Exception {
        User newdata = (User) DataChange.StringToMessage(message.getContent(),User.class);
        if(newdata.getUId()==message.getFrom()) userMapper.UpdateUserData(newdata);
        SendMessage.responseMessage(s,message,null,true);
    }

    @Override
    public void getUserName(Session s, Message message) throws Exception {
        ListGetRange range = (ListGetRange) DataChange.StringToMessage(message.getContent(),ListGetRange.class);
        LinkedList<String> list = new LinkedList<>();
        for(long uid:range.getList()){
            String name = redisTemplate.boundValueOps(String.valueOf(uid)).get();
            if(name==null){
                name = userMapper.getUserName(uid);
                redisTemplate.boundValueOps(String.valueOf(uid)).set(name,600, TimeUnit.SECONDS);
            }
            list.add(name);
        }
        SendMessage.responseMessage(s,message,(Object)list,true);
    }
}
