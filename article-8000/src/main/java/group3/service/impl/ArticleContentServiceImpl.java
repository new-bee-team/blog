package group3.service.impl;

import group2.entity.pojo.ArticleContentDO;
import group2.returnJson.Result;
import group3.service.IArticleContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-06-05 09:23
 * @description:
 **/

@Service
@Slf4j
public class ArticleContentServiceImpl implements IArticleContentService {
    @Override
    public Result getArticleContent(Integer articleId) {
        return null;
    }

    @Override
    public Result updateArticleContent(Integer article, String content) {
        return null;
    }

    @Override
    public Result saveArticleContent(ArticleContentDO articleContent) {
        return null;
    }

    @Override
    public Result deleteArticleContent(Integer articleId) {
        return null;
    }
}
