package com.daydayboom.Service.UndoArticleService;

import com.daydayboom.Bean.Message;

import javax.websocket.Session;
import java.io.IOException;

public interface UndoArticleServiceImp {
    public void service(Session s,Message message) throws Exception;
    public void submitArticle(Session s, Message message) throws Exception;
    public void changeUndoArticle(Session s,Message message) throws Exception;
    public void getUndoArticle(Session s,Message message) throws Exception;
    public void deleteUndoArticle(Session s,Message message) throws Exception;
    public void changeArticle(Session s,Message message) throws Exception;
}
