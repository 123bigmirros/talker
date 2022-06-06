package com.daydayboom.Bean.Userdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public final static int LOGIN_REGISTER = 0;
    public final static int GET_USERDATA = 1;
    public final static int CHANGE_USERDATA = 2;
    public final static int GET_USER_NAME =  3;
    private String Phone;//作为电话
    private String Name;//
    private String WeChat;
    private String QQ;
    private long RTime;
    private long Agree;
    private long Disagree;
    private long UId;
    public User(String Phone){
        this.Phone = Phone;
    }
}
