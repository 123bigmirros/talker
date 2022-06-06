package com.daydayboom.mapper;

import com.daydayboom.Bean.Answer.Answer;
import com.daydayboom.Bean.Article.UndoArticle;
import com.daydayboom.Bean.Range.DeleteRange;
import com.daydayboom.Bean.Range.GetRange;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnswerMapper {

    @Select("select * from Answer  where OwnerId = #{AimId} limit #{Begin},#{Len} ")
    public List<Answer> getOwnAnswer(GetRange getRange);

    @Select("select * from Answer where FId = #{AimId} and LabelId = #{Type} limit #{Begin},#{Len} ")
    public List<Answer> getAnswer(GetRange range);

    @Delete("delete from Answer where Id = #{AimId}")
    public void deleteAnswer(DeleteRange range);
}
