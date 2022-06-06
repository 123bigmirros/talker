package com.daydayboom.Service.CommentService;

import com.daydayboom.Bean.Comment.Comment;
import com.daydayboom.Bean.Message;
import com.daydayboom.Bean.Range.DeleteRange;
import com.daydayboom.Bean.Range.GetRange;
import com.daydayboom.Instrument.DataChange;
import com.daydayboom.Instrument.SendMessage;
import com.daydayboom.Instrument.SpringUtil;
import com.daydayboom.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.List;

@Service
public class CommentService implements CommentServiceImp{
    CommentMapper commentMapper = (CommentMapper) SpringUtil.getBean("commentMapper");
    @Override
    public void service(Session s, Message message) throws Exception {
        if(message.getTypeVariety()==Comment.SUBMIT_COMMENT) submitComment(s,message);
        else if(message.getTypeVariety()==Comment.GET_COMMENT) getComment(s,message);
        else if(message.getTypeVariety()==Comment.GET_SON_COMMENT) getSonComment(s,message);
        else if(message.getTypeVariety()==Comment.DELETE_COMMENT) deleteComment(s,message);
    }

    @Override
    public void submitComment(Session s, Message message) {
        Comment comment = (Comment) DataChange.StringToMessage(message.getContent(), Comment.class);
        commentMapper.submitComment(comment);
    }

    @Override
    public void getComment(Session s, Message message) throws Exception {
        GetRange range = (GetRange) DataChange.StringToMessage(message.getContent(),GetRange.class);
        List<Comment> comments = commentMapper.getComment(range);
        SendMessage.responseMessage(s,message,comments,true);
    }

    @Override
    public void getSonComment(Session s, Message message) throws Exception {
        GetRange range = (GetRange) DataChange.StringToMessage(message.getContent(),GetRange.class);
        List<Comment> comments =commentMapper.getSonComment(range);
        SendMessage.responseMessage(s,message,comments,true);
    }

    @Override
    public void deleteComment(Session s, Message message) throws Exception {
        DeleteRange range = (DeleteRange) DataChange.StringToMessage(message.getContent(),DeleteRange.class);
        commentMapper.deleteComment(range);
        SendMessage.responseMessage(s,message,null,true);
    }


}
