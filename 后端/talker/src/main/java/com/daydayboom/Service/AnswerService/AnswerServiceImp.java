package com.daydayboom.Service.AnswerService;

import com.daydayboom.Bean.Message;

import javax.websocket.Session;
import java.io.IOException;

public interface AnswerServiceImp {
    public void service(Session s, Message message) throws Exception;
    public void getOwnAnswer(Session s,Message message) throws Exception;
    public void getAnswer(Session s,Message message) throws Exception;
    public void deleteAnswer(Session s,Message message) throws Exception;
}
