package group1.service.impl;

import group1.service.IUserStarService;
import group2.returnJson.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-06-04 17:28
 * @description: 用户收藏文章相关服务
 **/

@Service
@Slf4j
public class UserStarServiceImpl implements IUserStarService {
    @Override
    public Result listStarArticle(Integer userId, Boolean desc, Integer startPage, Integer pageInfo) {
        return null;
    }

    @Override
    public Result getStarArticle(Integer articleId) {
        return null;
    }

    @Override
    public Result saveStarArticle(Integer userId, Integer articleId) {
        return null;
    }

    @Override
    public Result deleteStarArticle(Integer userId, Integer articleId) {
        return null;
    }
}
