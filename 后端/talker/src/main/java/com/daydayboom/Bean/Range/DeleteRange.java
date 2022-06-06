package com.daydayboom.Bean.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRange {
    private long UserId;
    private long AimId;
    private long EndId;
    private int type;
}
