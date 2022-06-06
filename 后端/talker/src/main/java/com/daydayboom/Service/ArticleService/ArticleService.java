package com.daydayboom.Service.ArticleService;

import com.daydayboom.Bean.Article.Article;
import com.daydayboom.Bean.Article.Label;
import com.daydayboom.Bean.Article.UndoArticle;
import com.daydayboom.Bean.Message;
import com.daydayboom.Bean.Range.DeleteRange;
import com.daydayboom.Bean.Range.GetRange;
import com.daydayboom.Instrument.DataChange;
import com.daydayboom.Instrument.SendMessage;
import com.daydayboom.Instrument.SpringUtil;
import com.daydayboom.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import javax.websocket.Session;
import java.util.List;

@Service
public class ArticleService implements ArticleServiceImp{
    ArticleMapper articleMapper = (ArticleMapper) SpringUtil.getBean("articleMapper");
    @Override
    public void service(Session s, Message message) throws Exception {
        if(message.getTypeVariety()==Article.GET_OWN_ARTICLE)getOwnArticle(s,message);
        else if(message.getTypeVariety()==Article.GET_ARTICLE) getArticle(s,message);
        else if(message.getTypeVariety()==Article.DELETE_ARTICLE) deleteArticle(s,message);
        else if(message.getTypeVariety()==Article.GET_LABEL) getLabel(s,message);
    }

    @Override
    public void getOwnArticle(Session s, Message message) throws Exception {
        GetRange range = (GetRange) DataChange.StringToMessage(message.getContent(),GetRange.class);
        List<Article> articles  = null;
        articles = articleMapper.getOwnArticle(range);
        SendMessage.responseMessage(s,message, articles.toArray(), true);
    }

    @Override
    public void getArticle(Session s, Message message) throws Exception {
        GetRange range = (GetRange) DataChange.StringToMessage(message.getContent(),GetRange.class);
        List<Article> articles = articleMapper.getArticle(range);
        SendMessage.responseMessage(s,message,articles,true);
    }

    @Override
    public void deleteArticle(Session s, Message message) throws Exception {
        DeleteRange deleteRange = (DeleteRange) DataChange.StringToMessage(message.getContent(),DeleteRange.class);
        articleMapper.deleteArticle(deleteRange);
        SendMessage.responseMessage(s,message,null,true);
    }

    @Override
    public void getLabel(Session s, Message message) throws Exception {
        GetRange range = (GetRange) DataChange.StringToMessage(message.getContent(),GetRange.class);
        List<Label> labels = articleMapper.getLabel(range);
        SendMessage.responseMessage(s,message,labels,true);
    }
}
