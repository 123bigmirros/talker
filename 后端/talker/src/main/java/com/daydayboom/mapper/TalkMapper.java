package com.daydayboom.mapper;

import com.daydayboom.Bean.Range.DeleteRange;
import com.daydayboom.Bean.Talk.TalkMessage;
import com.daydayboom.Bean.Userdata.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TalkMapper {
    @Insert("insert into talkmessage(FromUser,ToUser,Content) values(#{From},#{To},#{Content})")
    public void saveMessage(TalkMessage message);

    @Select("select * from talkmessage where ToUser = #{UId}")
    public List<TalkMessage> getMessage(User user);

    @Delete("delete from talkmessage where Id>=#{AimId} and Id <= #{EndId} and FromUser = #{UserId}")
    public void deleteMessage(DeleteRange range);

    @Select("select max(Id) from talkmessage")
    public long getMaxMessageNum();
}
