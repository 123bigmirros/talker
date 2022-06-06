package com.daydayboom.Service.TalkService;

import com.daydayboom.Bean.Message;
import com.daydayboom.Bean.Range.DeleteRange;
import com.daydayboom.Bean.Talk.TalkMessage;
import com.daydayboom.Bean.Userdata.User;
import com.daydayboom.Config.Container;
import com.daydayboom.Config.Variety;
import com.daydayboom.Instrument.DataChange;
import com.daydayboom.Instrument.SendMessage;
import com.daydayboom.Instrument.SpringUtil;
import com.daydayboom.mapper.TalkMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TalkService implements TalkServiceImp{

    static TalkMapper talkMapper = (TalkMapper) SpringUtil.getBean("talkMapper");
    static AtomicLong talk_num = new AtomicLong(1);
//    static AtomicLong talk_num = new AtomicLong(talkMapper.getMaxMessageNum()+1);
    static RedisTemplate<String,String> redisTemplate = (RedisTemplate<String, String>) SpringUtil.getBean("redisTemplate");
    @Override
    public void service(Session s, Message message) throws Exception {
        if(message.getTypeVariety()== TalkMessage.SEND_MESSAGE)sendMessage(s,message);
        else if(message.getTypeVariety()==TalkMessage.DELETE_MESSAGE) deleteMessage(s,message);
    }

    @Override
    public void sendMessage(Session s, Message message) throws Exception {

        TalkMessage talkMessage = (TalkMessage) DataChange.StringToMessage(message.getContent(),TalkMessage.class);
        Session to = Container.UserSession.get(talkMessage.getTo());
        //redisTemplate.boundValueOps(String.valueOf(talk_num.getAndIncrement())+'T').set(message.getContent());

        talkMapper.saveMessage(talkMessage);
        if(to!=null) SendMessage.responseMessage(to,message,talkMessage,true);
    }

    @Override
    public void getMessage(Session s, User user) throws Exception {
        List<TalkMessage> talkMessages = talkMapper.getMessage(user);
        Message message = new Message(Variety.TALK_OPT,TalkMessage.GET_MESSAGE,-1,user.getUId(),null);
        SendMessage.responseMessage(s,message,talkMessages,true);
    }

    @Override
    public void deleteMessage(Session s, Message message) {
        DeleteRange range = (DeleteRange) DataChange.StringToMessage(message.getContent(),DeleteRange.class);
        talkMapper.deleteMessage(range);
    }
}
