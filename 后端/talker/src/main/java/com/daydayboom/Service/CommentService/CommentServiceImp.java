package com.daydayboom.Service.CommentService;

import com.daydayboom.Bean.Message;

import javax.websocket.Session;
import java.io.IOException;

public interface CommentServiceImp {
    public void service(Session s, Message message) throws Exception;
    public void submitComment(Session s,Message message);
    public void getComment(Session s,Message message) throws Exception;
    public void getSonComment(Session s,Message message) throws Exception;
    public void deleteComment(Session s,Message message) throws Exception;
}
