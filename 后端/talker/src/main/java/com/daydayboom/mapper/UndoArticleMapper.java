package com.daydayboom.mapper;

import com.daydayboom.Bean.Article.UndoArticle;
import com.daydayboom.Bean.Range.DeleteRange;
import com.daydayboom.Bean.Range.GetRange;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UndoArticleMapper {

    @Insert("insert into UndoArticle(OwnerId,FId,Label,IsNewLabel,Headline,Content,Time)"+
            "Values(#{OwnerId},#{FId},#{Label},#{IsNewLabel},#{Headline},#{Content},#{Time})")
    public UndoArticle submitArticle(UndoArticle undoArticle);

    @Insert("insert into UndoArticle(OwnerId,Id,Headline,Content,Status)"+
            "Values(#{OwnerId},#{Id},#{Headline},#{Content},#{Status})")
    public void changeArticle(UndoArticle article);

    @Update("update UndoArticle set Label = #{Label},IsNewLabel = #{IsNewLabel},Headline = #{Headline},Content = #{Content},Response = #{Response} where OwnerId = #{OwnerId}")
    public void changeUndoArticle(UndoArticle undoArticle);

    @Select("select * from UndoArticle where Owner = #{Owner}  limit #{Begin},#{Len}")
    public List<UndoArticle> getUndoArticleByRange(GetRange getRange);

    @Select("select * from UndoArticle where Id = #{AimId}")
    public List<UndoArticle> getUndoArticleById(GetRange getRange);

    @Delete("delete from UndoArticle where Id = #{AimId}")
    public void deleteUndoArticle(DeleteRange deleteRange);

    @Insert("insert into Article(Id,OwnerId,Type,Headline,Content)"+
    "values(#{Id},#{Owner},0,Headline,Content)")
    public void insertArticle(UndoArticle article);

    @Insert("insert into Answer(Id,FId,LabelId,OwnerId,Headline,Content)"+
    "values(#{Id},#{FId},#{IsNewLabel},#{OwnerId},#{Headline},#{Content})")
    public void insertAnswer(UndoArticle article);
}
