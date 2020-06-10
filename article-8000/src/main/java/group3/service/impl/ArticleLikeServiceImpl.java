package group3.service.impl;

import group2.returnJson.Result;
import group3.service.IArticleLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-06-05 09:24
 * @description:
 **/

@Service
@Slf4j
public class ArticleLikeServiceImpl implements IArticleLikeService {
    @Override
    public Result getArticleLike(Integer articleId) {
        return null;
    }

    @Override
    public Result updateArticleLikeStatus(Integer userId, Integer articleId, Integer status) {
        return null;
    }

    @Override
    public Result updateArticleLike(Integer articleId, Integer like, Integer operation) {
        return null;
    }

    @Override
    public Result saveArticleLike(Integer userId, Integer articleId) {
        return null;
    }

    @Override
    public Result deleteArticleLike(Integer userId, Integer articleId) {
        return null;
    }
}
