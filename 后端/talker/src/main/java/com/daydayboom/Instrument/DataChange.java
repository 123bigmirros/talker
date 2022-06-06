package com.daydayboom.Instrument;

import com.alibaba.fastjson.JSON;
import com.daydayboom.Bean.Message;
import org.springframework.ui.Model;


public class DataChange{
    //为来应该添加信息识别功能
    public static Object StringToMessage(String message,Class kind){

        return  JSON.parseObject(message,kind);

    }
    public static String MessageToString(Object message){
        return JSON.toJSONString(message);
    }
}
