package com.daydayboom.Bean.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRange {
    public static final int GET_ARTICLE = 0;
    public static final int GET_LABEL_ARTICLE= 1;
    public static final int GET_UNDOARTICLE_ID = 2;
    public static final int GET_UNDOARTICLE_RANGE = 3;
    private long AimId;
    private long Begin;
    private int Len;
    private int Type;
}
