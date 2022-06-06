package com.daydayboom.Service.TalkService;

import com.daydayboom.Bean.Message;
import com.daydayboom.Bean.Userdata.User;

import javax.websocket.Session;
import java.io.IOException;

public interface TalkServiceImp {
    public void service(Session s, Message message) throws Exception;
    public void sendMessage(Session s,Message message) throws Exception;
    public void getMessage(Session s, User user) throws Exception;
    public void deleteMessage(Session s,Message message);
}
