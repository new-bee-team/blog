package group3.service.impl;

import group2.returnJson.Result;
import group3.service.IArticleStarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-06-05 09:25
 * @description:
 **/

@Service
@Slf4j
public class ArticleStarServiceImpl implements IArticleStarService {
    @Override
    public Result getArticleStar(Integer articleId) {
        return null;
    }

    @Override
    public Result updateArticleStarStatus(Integer userId, Integer articleId, Integer status) {
        return null;
    }

    @Override
    public Result updateArticleStar(Integer articleId, Integer star, Integer operation) {
        return null;
    }

    @Override
    public Result saveArticleStar(Integer userId, Integer articleId) {
        return null;
    }

    @Override
    public Result deleteArticleStar(Integer userId, Integer articleId) {
        return null;
    }
}
