package com.daydayboom.Instrument;


import com.daydayboom.Bean.Message;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;

public class SendMessage {
    public static void sendMessage(Session s, Message message) throws  Exception {
        System.out.println(DataChange.MessageToString(message));
        s.getBasicRemote().sendText(DataChange.MessageToString(message));
    }

    public static void responseMessage(Session s,Message message,Object newConetent,boolean ok) throws Exception {
        if(newConetent!=null)message.setContent(DataChange.MessageToString(newConetent));
        else message.setContent(null);
        if(!ok) message.setType(-message.getType());
        sendMessage(s,message);
    }
}
