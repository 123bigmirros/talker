package com.daydayboom;


import com.daydayboom.Bean.Message;
import com.daydayboom.Controller.Controller;

import com.daydayboom.Instrument.DataChange;
import com.daydayboom.Instrument.SpringUtil;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;


import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/")
@Component
@DependsOn("springUtil")
public class Enter {


    private static Controller controller = (Controller)SpringUtil.getBean("controller");


    @OnOpen
    public void onOpen(Session session) throws Exception {
        //System.out.println("连接建立");
    }
    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        System.out.println(session.getId());
        controller.JudgeService(session,(Message) DataChange.StringToMessage(message, Message.class) );
    }
    @OnClose
    public void onClose(Session session) throws Exception {
        System.out.println("连接关闭");
        controller.remove(session);
    }



    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println(error);
    }

}
