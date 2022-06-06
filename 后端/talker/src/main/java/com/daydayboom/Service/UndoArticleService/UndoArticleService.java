package com.daydayboom.Service.UndoArticleService;
import com.daydayboom.Bean.Article.UndoArticle;
import com.daydayboom.Bean.Message;
import com.daydayboom.Bean.Range.DeleteRange;
import com.daydayboom.Bean.Range.GetRange;
import com.daydayboom.Instrument.DataChange;
import com.daydayboom.Instrument.SendMessage;
import com.daydayboom.Instrument.SpringUtil;
import com.daydayboom.mapper.UndoArticleMapper;
import org.springframework.stereotype.Component;
import javax.websocket.Session;
import java.util.List;

@Component
public class UndoArticleService implements UndoArticleServiceImp {

    UndoArticleMapper undoArticleMapper = (UndoArticleMapper) SpringUtil.getBean("undoArticleMapper");
    @Override
    public void service(Session s, Message message) throws Exception {
        if(message.getTypeVariety()== UndoArticle.SUBMIT_ARTICLE) submitArticle(s,message);
        else if(message.getTypeVariety()==UndoArticle.CHANGE_UNDOARTICLE) changeUndoArticle(s,message);
        else if(message.getTypeVariety() == UndoArticle.GETUNDOARTICLE) getUndoArticle(s,message);
        else if(message.getTypeVariety()==UndoArticle.DELETE_UNDOARTICLE) deleteUndoArticle(s,message);
        else if(message.getTypeVariety()==UndoArticle.CHANGE_ARTICLE) changeArticle(s,message);
    }

    @Override
    public void submitArticle(Session s, Message message) throws Exception {
        UndoArticle undoArticle = (UndoArticle) DataChange.StringToMessage(message.getContent(),UndoArticle.class);
        undoArticle = undoArticleMapper.submitArticle(undoArticle);
        if(undoArticle.getFId()==-1) undoArticleMapper.insertArticle(undoArticle);
        else if(undoArticle.getIsNewLabel()!=0) undoArticleMapper.insertAnswer(undoArticle);
        SendMessage.responseMessage(s,message,null,true);
    }

    @Override
    public void changeUndoArticle(Session s, Message message) throws Exception {
        UndoArticle undoArticle = (UndoArticle) DataChange.StringToMessage(message.getContent(),UndoArticle.class);
        undoArticleMapper.changeUndoArticle(undoArticle);
        SendMessage.responseMessage(s,message,null,true);
    }

    @Override
    public void getUndoArticle(Session s, Message message) throws Exception {
        GetRange range = (GetRange) DataChange.StringToMessage(message.getContent(),GetRange.class);
        List<UndoArticle> undoArticles = null;
        if(range.getType()==GetRange.GET_UNDOARTICLE_ID) undoArticles = undoArticleMapper.getUndoArticleById(range);
        else undoArticles =  undoArticleMapper.getUndoArticleByRange(range);
        SendMessage.responseMessage(s,message,undoArticles,true);
    }

    @Override
    public void deleteUndoArticle(Session s, Message message) throws Exception {
        DeleteRange deleteRange = (DeleteRange) DataChange.StringToMessage(message.getContent(),DeleteRange.class);
        undoArticleMapper.deleteUndoArticle(deleteRange);
        SendMessage.responseMessage(s,message,null,true);
    }

    @Override
    public void changeArticle(Session s, Message message) throws Exception {
        UndoArticle undoArticle = (UndoArticle) DataChange.StringToMessage(message.getContent(),UndoArticle.class);
        undoArticleMapper.changeArticle(undoArticle);
        SendMessage.responseMessage(s,message,null,true);
    }
}
