package group3.service.impl;

import group2.entity.pojo.ArticleCommentDO;
import group2.returnJson.Result;
import group3.service.IArticleCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-06-05 09:22
 * @description:
 **/

@Service
@Slf4j
public class ArticleCommentServiceImpl implements IArticleCommentService {
    @Override
    public Result getArticleComments(Integer articleId) {
        return null;
    }

    @Override
    public Result saveArticleComment(ArticleCommentDO articleComment) {
        return null;
    }

    @Override
    public Result deleteArticleComment(Integer id) {
        return null;
    }
}
