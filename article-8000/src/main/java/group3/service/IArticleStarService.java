package group3.service;

import group2.returnJson.Result;

public interface IArticleStarService {
    // ---------------------查---------------------------
    // 查询文章的总收藏数
    Result getArticleStar(Integer articleId);
    // ---------------------改---------------------------
    // 更新收藏的状态
    Result updateArticleStarStatus(Integer userId,Integer articleId,Integer status);
    // 更新文章的总收藏数 0———增加   1————减少
    Result updateArticleStar(Integer articleId,Integer star,Integer operation);
    // ---------------------增---------------------------
    // 新增用户收藏记录
    Result saveArticleStar(Integer userId,Integer articleId);
    // ---------------------删---------------------------
    // 定时任务删除
    Result deleteArticleStar(Integer userId,Integer articleId);
}
