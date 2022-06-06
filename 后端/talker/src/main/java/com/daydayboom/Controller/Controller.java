package com.daydayboom.Controller;


import com.daydayboom.Bean.Message;
import com.daydayboom.Config.Container;
import com.daydayboom.Config.Variety;
import com.daydayboom.Instrument.SpringUtil;
import com.daydayboom.Service.OtherService.OtherService;
import com.daydayboom.Service.AnswerService.AnswerService;
import com.daydayboom.Service.ArticleService.ArticleService;
import com.daydayboom.Service.CommentService.CommentService;
import com.daydayboom.Service.SearchService.SearchService;
import com.daydayboom.Service.TalkService.TalkService;
import com.daydayboom.Service.UndoArticleService.UndoArticleService;
import com.daydayboom.Service.UserService.UserService;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.websocket.Session;

@Component
@DependsOn("springUtil")
public class Controller {

    static UserService userService = (UserService)SpringUtil.getBean("userService");
    static UndoArticleService undoArticleService = (UndoArticleService)SpringUtil.getBean("undoArticleService");
    static ArticleService articleService = (ArticleService)SpringUtil.getBean("articleService");
    static AnswerService answerService = (AnswerService)SpringUtil.getBean("answerService");
    static CommentService commentService = (CommentService)SpringUtil.getBean("commentService");
    static OtherService otherService = (OtherService)SpringUtil.getBean("otherService");
    static TalkService talkService = (TalkService) SpringUtil.getBean("talkService");
    static SearchService searchService = (SearchService) SpringUtil.getBean("searchService");
    public void JudgeService(Session s, Message message) throws Exception {
        int type = message.getType();
        if(type==Variety.USER_DATA_OPT) userService.service(s,message);
        else if(type==Variety.SUBMIT_ARTICLE_OPT) undoArticleService.service(s,message);
        else if(type==Variety.ARTICLE_OPT) articleService.service(s,message);
        else if(type==Variety.ANSWER_OPT) answerService.service(s,message);
        else if(type==Variety.COMMENT_OPT) commentService.service(s,message);
        else if(type==Variety.OTHER_OPT) otherService.service(s,message);
        else if(type==Variety.TALK_OPT) talkService.service(s,message);
        else if(type==Variety.SEARCH_OPT) searchService.service(s,message);
    }

    public void remove(Session s){
        long uid = Container.SessionIdUser.remove(s.getId());
        if(uid==0) return;
        else Container.UserSession.remove(s.getId());
    }
}
