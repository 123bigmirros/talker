package com.daydayboom.Service.SearchService;

import com.daydayboom.Bean.Message;
import org.springframework.stereotype.Service;

import javax.websocket.Session;

@Service
public class SearchService implements SearchServiceImp{
    @Override
    public void service(Session s, Message message) {

    }
}
