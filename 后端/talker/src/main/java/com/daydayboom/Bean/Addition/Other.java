package com.daydayboom.Bean.Addition;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Other {
    public final static int AGREE = 0;
    public final static int CANCEAL_AGREE = 1;
    public final static int DIS_AGREE = 2;
    public final static int CONCEAL_DIS_AGREE = 3;
    public final static int COLLECTION = 4;
    public final static int CANCEAL_COLLECTON = 5;
    public final static int GET_COLLECTION_ARTICLE = 6;

    public final static int ARTICLE_T = 0;
    public final static int COMMENT_T = 1;
    private long UserId;
    private long AimId;
    private long Type;
}
