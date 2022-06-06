package com.daydayboom.mapper;

import com.daydayboom.Bean.Comment.Comment;
import com.daydayboom.Bean.Range.DeleteRange;
import com.daydayboom.Bean.Range.GetRange;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into Comment(OwnerId,FOwnerId,ArticleId,Fid,Content,Time)"+
    "values(#{OwnerId},#{FOwnerId},#{ArticleId},#{Fid},#{Content},#{Time}")
    public void submitComment(Comment comment);

    @Select("select * from Comment where ArticleId = #{AimId} limit #{Begin},#{Len} ")
    public List<Comment> getComment(GetRange range);

    @Select("select * from Comment where FId = #{AimId} limit #{Begin},#{Len}")
    public List<Comment> getSonComment(GetRange range);

    @Delete("delete from Comment where Id = #{AimId}")
    public void deleteComment(DeleteRange range);
}
