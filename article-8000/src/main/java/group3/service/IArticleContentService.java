package group3.service;

import group2.entity.pojo.ArticleContentDO;
import group2.returnJson.Result;

public interface IArticleContentService {
    //---------------查---------------------
    Result getArticleContent(Integer articleId);
    //---------------改---------------------
    Result updateArticleContent(Integer article,String content);
    //---------------增---------------------
    Result saveArticleContent(ArticleContentDO articleContent);
    //---------------删---------------------
    // 定时任务
    Result deleteArticleContent(Integer articleId);
}
