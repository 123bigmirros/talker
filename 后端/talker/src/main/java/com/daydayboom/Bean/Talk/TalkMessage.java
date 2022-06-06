package com.daydayboom.Bean.Talk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalkMessage {
    public static final int SEND_MESSAGE = 0;
    public static final int DELETE_MESSAGE = 1;
    public static final int GET_MESSAGE = 2;
    public long Id;//信息ID
    public long From;//发起者用户ID
    public long To;//信息接收者ID
    public long Time;
    public String Content;//内容
}
