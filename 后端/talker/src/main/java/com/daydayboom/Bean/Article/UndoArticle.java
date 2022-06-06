package com.daydayboom.Bean.Article;

import com.daydayboom.Bean.Answer.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UndoArticle {
    //操作类型
    public static final int SUBMIT_ARTICLE = 0;
    public static final int CHANGE_UNDOARTICLE = 1;
    public static final int GETUNDOARTICLE = 2;
    public static final int DELETE_UNDOARTICLE = 3;
    public static final int CHANGE_ARTICLE = 4;
    //get类型
    public static final int UNCHECK = 0;
    public static final int DISAGREE = 1;

    private long OwnerId;//发布者ID
    private long Id;//文章自身ID
    private long FId;//父ID
    private String Label;//标签
    private int IsNewLabel;//判断是否为新标签
    private String Headline;//标题
    private String Content;//内容
    private long Time;
    private int Status;//文章状态,用于区分是新发布的文章还是文章修改
    private String Response;//文章不通过时后台管理员的建议
}
