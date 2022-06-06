package com.daydayboom.mapper;


import com.daydayboom.Bean.Addition.Other;
import com.daydayboom.Bean.Article.Article;
import com.daydayboom.Bean.Range.GetRange;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OtherMapper {
    @Update("update Article set Agree = Agree + #{Agree},Disagree = Disagree + #{Disagree} where Id = #{AimId}")
    public void thumbArticle(long AimId,int Agree,int Disagree);
    @Update("update Comment set Agree = Agree + #{Agree},Disagree = Disagree + #{Disagree} where Id = #{AimId}")
    public void thumbComment(long AimId,int Agree,int Disagree);
    @Insert("insert into Collection(UId,ArticleId) values(#{UserId},#{AimId})")
    public void collection(Other other);
    @Delete("delete from Collection where UId = #{UserId} and ArticleId = #{AimId}")
    public void concealCollection(Other other);
    @Select("select * from Article where Id in "
    +"(select ArticleId from Collection where UId = #{AimId} limit #{Begin},#{Len})")
    public List<Article> getColletionArticle(GetRange range);
}
