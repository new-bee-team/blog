package group3.service;

import group2.returnJson.Result;

public interface IArticleLikeService {
    // ---------------------查---------------------------
    // 查询文章的总点赞数
    Result getArticleLike(Integer articleId);
    // ---------------------改---------------------------
    // 更新点赞的状态
    Result updateArticleLikeStatus(Integer userId,Integer articleId,Integer status);
    // 更新文章的总点赞数 0———增加   1————减少
    Result updateArticleLike(Integer articleId,Integer like,Integer operation);
    // ---------------------增---------------------------
    // 新增用户点赞记录
    Result saveArticleLike(Integer userId,Integer articleId);
    // ---------------------删---------------------------
    // 定时任务删除
    Result deleteArticleLike(Integer userId,Integer articleId);
}
