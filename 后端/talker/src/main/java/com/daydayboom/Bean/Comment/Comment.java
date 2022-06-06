package com.daydayboom.Bean.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    public static final int SUBMIT_COMMENT = 0;
    public static final int GET_COMMENT = 1;
    public static final int GET_SON_COMMENT = 2;
    public static final int DELETE_COMMENT = 3;
    private long OwnerId;//评论用户Id
    private long ArticleId;//文章ID
    private long Fid;//父评论ID
    private long Id;//评论自身ID
    private String Content;//内容
    private long Time;
    private long Agree;
    private long Disagree;
}
