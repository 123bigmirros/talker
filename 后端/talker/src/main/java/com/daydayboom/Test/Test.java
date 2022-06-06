package com.daydayboom.Test;

import com.daydayboom.Bean.Userdata.User;
import com.daydayboom.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("test")
public class Test {
    @Autowired
    UserMapper userMapper;
    public void test(){
        System.out.println(userMapper);
    }
}
