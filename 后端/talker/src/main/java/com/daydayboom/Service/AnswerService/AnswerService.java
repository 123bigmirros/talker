package com.daydayboom.Service.AnswerService;

import com.daydayboom.Bean.Answer.Answer;
import com.daydayboom.Bean.Article.UndoArticle;
import com.daydayboom.Bean.Message;
import com.daydayboom.Bean.Range.DeleteRange;
import com.daydayboom.Bean.Range.GetRange;
import com.daydayboom.Config.Variety;
import com.daydayboom.Instrument.DataChange;
import com.daydayboom.Instrument.SendMessage;
import com.daydayboom.Instrument.SpringUtil;
import com.daydayboom.mapper.AnswerMapper;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.io.IOException;
import java.util.List;

@Service
public class AnswerService implements AnswerServiceImp{

    AnswerMapper answerMapper = (AnswerMapper) SpringUtil.getBean("answerMapper");
    @Override
    public void service(Session s, Message message) throws Exception {
        if(message.getTypeVariety()==Answer.GET_OWN_ANSWER) getOwnAnswer(s,message);
        else if(message.getTypeVariety() == Answer.GET_ANSWER) getAnswer(s,message);
        else if(message.getTypeVariety()==Answer.DELETE_ANSWER) deleteAnswer(s,message);

    }

    @Override
    public void getOwnAnswer(Session s, Message message) throws Exception {
        GetRange range = (GetRange) DataChange.StringToMessage(message.getContent(), GetRange.class);
        List<Answer> answers = answerMapper.getOwnAnswer(range);
        SendMessage.responseMessage(s,message,answers,true);
    }

    @Override
    public void getAnswer(Session s, Message message) throws Exception {
        GetRange range = (GetRange) DataChange.StringToMessage(message.getContent(), GetRange.class);
        List<Answer> answers = null;
        answers = answerMapper.getAnswer(range);
        SendMessage.responseMessage(s,message,answers,true);
    }



    @Override
    public void deleteAnswer(Session s, Message message) throws Exception {
        DeleteRange range = (DeleteRange) DataChange.StringToMessage(message.getContent(),DeleteRange.class);
        answerMapper.deleteAnswer(range);
        SendMessage.responseMessage(s,message,null,true);
    }
}
