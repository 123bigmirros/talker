package com.daydayboom.Service.ArticleService;

import com.daydayboom.Bean.Message;

import javax.websocket.Session;
import java.io.IOException;

public interface ArticleServiceImp {
    public void service(Session s, Message message) throws Exception;
    public void getOwnArticle(Session s,Message message) throws Exception;
    public void getArticle(Session s,Message message) throws Exception;
    public void deleteArticle(Session s,Message message) throws Exception;
    public void getLabel(Session s,Message message) throws Exception;
}
