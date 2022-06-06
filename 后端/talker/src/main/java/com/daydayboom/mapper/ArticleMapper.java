package com.daydayboom.mapper;

import com.daydayboom.Bean.Article.Article;
import com.daydayboom.Bean.Article.Label;
import com.daydayboom.Bean.Article.UndoArticle;
import com.daydayboom.Bean.Range.DeleteRange;
import com.daydayboom.Bean.Range.GetRange;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Select("select * from Article where OwnerId = #{AimId} limit #{Begin},#{len} ")
    public List<Article> getOwnArticle(GetRange getRange);

    @Select("select * from Article where Id >= #{Begin} limit 0,#{Len}")
    public List<Article> getArticle(GetRange range);

    @Delete("delete from Article where Id = #{AimId}")
    public void deleteArticle(DeleteRange range);

    @Select("select * from Label where FId = #{AimId}")
    public List<Label> getLabel(GetRange range);
}
