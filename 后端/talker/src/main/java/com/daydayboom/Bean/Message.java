package com.daydayboom.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int Type;
    private int TypeVariety;
    private long From;
    private long To;
    private String content;
}
