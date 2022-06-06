package com.daydayboom.Config;

import com.daydayboom.Bean.Userdata.User;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Container {
    public static Map<Long, Session> UserSession=new ConcurrentHashMap();
    public static Map<String,Long> SessionIdUser = new ConcurrentHashMap<>();
    public static void bind(Session s, User user){
        Container.UserSession.put(user.getUId(),s);
        Container.SessionIdUser.put(s.getId(),user.getUId());
    }
}
