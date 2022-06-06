package com.daydayboom.Service.OtherService;

import com.daydayboom.Bean.Message;

import javax.websocket.Session;

public interface OtherServiceImp {
    public void service(Session s, Message message) throws Exception;
    public void agree(Session s,Message message);
    public void cancealAgree(Session s,Message message);
    public void disAgree(Session s,Message message);
    public void cancealDisAgree(Session s,Message message);
    public void collection(Session s,Message message);
    public void cancealCollection(Session s,Message message);
    public void getCollectionArticle(Session s,Message message) throws Exception;
}
