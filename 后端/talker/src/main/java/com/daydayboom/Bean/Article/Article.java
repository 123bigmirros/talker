package com.daydayboom.Bean.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    public static final int GET_OWN_ARTICLE  = 0;
    public static final int GET_ARTICLE = 1;
    public static final int DELETE_ARTICLE = 2;
    public static final int GET_LABEL = 3;
    public static final int IDEA = 0;
    public static final int TASK = 1;
    public static final int IDEA_SET = 2;
    private long OwnerId;//文章主人ID
    private long Id;//文章自身ID
    private int Type;//文章类型(想法、任务、问题集)
    private String Headline;//标题
    private String Content;//标题简洁
    private long Time;
    private long Agree;
    private long Disagree;
}
