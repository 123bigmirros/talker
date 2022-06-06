package com.daydayboom.Service.SearchService;

import com.daydayboom.Bean.Message;

import javax.websocket.Session;

public interface SearchServiceImp {
    public void service(Session s, Message message);
}
