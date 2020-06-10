package group3.service;

import group2.entity.pojo.ArticleCommentDO;
import group2.returnJson.Result;

public interface IArticleCommentService {
    //----------------查------------------------
    Result getArticleComments(Integer articleId);
    //----------------增------------------------
    Result saveArticleComment(ArticleCommentDO articleComment);
    //----------------删------------------------
    Result deleteArticleComment(Integer id);
    //----------------改------------------------
}
