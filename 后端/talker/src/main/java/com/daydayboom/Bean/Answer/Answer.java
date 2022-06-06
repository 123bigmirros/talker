package com.daydayboom.Bean.Answer;

import lombok.Data;

@Data
public class Answer {
    public static final int GET_OWN_ANSWER = 0;
    public static final int GET_ANSWER = 1;
    public static final int DELETE_ANSWER = 2;

    private long OwnerId;
    private long FId;
    private long LabelId;
    private long Id;
    private String Content;
    private long Time;
    private long agree;
    private long Disagree;
}
