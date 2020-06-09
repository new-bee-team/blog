package group3.service.impl;

import group2.returnJson.Result;
import group3.service.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: KongKongBaby
 * @create: 2020-06-05 09:24
 * @description:
 **/

@Service
@Slf4j
public class ArticleServiceImpl implements IArticleService {


    @Override
    public Result getArticleInfoById(Integer id) {
        return null;
    }

    @Override
    public Result getArticleInfoByUserId(Integer userId) {
        return null;
    }

    @Override
    public Result listArticlesByAuthorId(Integer authorId) {
        return null;
    }

    @Override
    public Result listArticlesByAuthorIdAndTime(Integer authorId, Long startTime, Long endTime) {
        return null;
    }

    @Override
    public Result updateStars(Integer id, Integer star) {
        return null;
    }

    @Override
    public Result updateComments(Integer id, Integer comment) {
        return null;
    }

    @Override
    public Result updateVisitors(Integer id, Integer visitor) {
        return null;
    }

    @Override
    public Result updateLikes(Integer id, Integer like) {
        return null;
    }

    @Override
    public Result updateOpen(Integer id, Integer open) {
        return null;
    }

    @Override
    public Result updateComment(Integer id, Integer comment) {
        return null;
    }

    @Override
    public Result updatePriority(Integer id, Integer priority) {
        return null;
    }

    @Override
    public Result updateCurrentMaxPriority(Integer id, Integer currentMaxPriority) {
        return null;
    }

    @Override
    public Result updateStatus(Integer id, Integer status) {
        return null;
    }

    @Override
    public Result updateLastUpdateTime(Integer id) {
        return null;
    }

    @Override
    public Result saveArticleInfo(Integer authorId) {
        return null;
    }
}
