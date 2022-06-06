package com.daydayboom.mapper;

import com.daydayboom.Bean.Userdata.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



@Mapper
public interface UserMapper {
    @Select("Select * from User where Phone = #{Phone}")
    public User GetByPhone(String Phone);

    @Select("select * from User where UId = #{UId}")
    public User GetById(long UId);

    @Insert("insert into User(Phone) values(#{Phone})")
    public User register(User user);

    @Update("Update User set name = #{name},WeChat = #{WeChat},QQ = #{QQ} where UId = #{UId}")
    public void UpdateUserData(User user);

    @Select("select name from User where UId = #{UId}")
    public String getUserName(long UId);
}
