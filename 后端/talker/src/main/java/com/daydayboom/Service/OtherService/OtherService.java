package com.daydayboom.Service.OtherService;

import com.daydayboom.Bean.Addition.Other;
import com.daydayboom.Bean.Article.Article;
import com.daydayboom.Bean.Message;
import com.daydayboom.Bean.Range.GetRange;
import com.daydayboom.Instrument.DataChange;
import com.daydayboom.Instrument.SendMessage;
import com.daydayboom.Instrument.SpringUtil;
import com.daydayboom.mapper.OtherMapper;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.List;

@Service
public class OtherService implements OtherServiceImp {

    OtherMapper otherMapper = (OtherMapper) SpringUtil.getBean("otherMapper");
    @Override
    public void service(Session s, Message message) throws Exception {
        if(message.getTypeVariety()== Other.AGREE) agree(s,message);
        else if(message.getTypeVariety()== Other.CANCEAL_AGREE) cancealAgree(s,message);
        else if(message.getTypeVariety()==Other.DIS_AGREE) disAgree(s,message);
        else if(message.getTypeVariety()==Other.CONCEAL_DIS_AGREE) cancealDisAgree(s,message);
        else if(message.getTypeVariety()==Other.COLLECTION) collection(s,message);
        else if(message.getTypeVariety()==Other.CANCEAL_COLLECTON) cancealCollection(s,message);
        else if(message.getTypeVariety()== Other.GET_COLLECTION_ARTICLE) getCollectionArticle(s,message);
    }

    @Override
    public void agree(Session s, Message message) {
        Other other = (Other) DataChange.StringToMessage(message.getContent(),Other.class);
        if(other.getType()==Other.ARTICLE_T) otherMapper.thumbArticle(other.getAimId(),1,0);
        else otherMapper.thumbComment(other.getAimId(),1,0);
    }

    @Override
    public void cancealAgree(Session s, Message message) {
        Other other = (Other) DataChange.StringToMessage(message.getContent(),Other.class);
        if(other.getType()==Other.ARTICLE_T) otherMapper.thumbArticle(other.getAimId(),-1,0);
        else otherMapper.thumbComment(other.getAimId(),-1,0);
    }

    @Override
    public void disAgree(Session s, Message message) {
        Other other = (Other) DataChange.StringToMessage(message.getContent(),Other.class);
        if(other.getType()==Other.ARTICLE_T) otherMapper.thumbArticle(other.getAimId(),0,1);
        else otherMapper.thumbComment(other.getAimId(),0,1);
    }

    @Override
    public void cancealDisAgree(Session s, Message message) {
        Other other = (Other) DataChange.StringToMessage(message.getContent(),Other.class);
        if(other.getType()==Other.ARTICLE_T) otherMapper.thumbArticle(other.getAimId(),0,-1);
        else otherMapper.thumbComment(other.getAimId(),0,-1);
    }

    @Override
    public void collection(Session s, Message message) {
        Other other = (Other) DataChange.StringToMessage(message.getContent(),Other.class);
        otherMapper.collection(other);
    }

    @Override
    public void cancealCollection(Session s, Message message) {
        Other other = (Other) DataChange.StringToMessage(message.getContent(),Other.class);
        otherMapper.concealCollection(other);
    }

    @Override
    public void getCollectionArticle(Session s, Message message) throws Exception {
        GetRange range = (GetRange) DataChange.StringToMessage(message.getContent(),GetRange.class);
        List<Article> list = otherMapper.getColletionArticle(range);
        SendMessage.responseMessage(s,message,(Object) list,true);
    }


}
