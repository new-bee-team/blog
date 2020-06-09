package group3.service;

import group2.returnJson.Result;

public interface IArticleService {
    // -----------------------------查------------------------------------------
    // 查询文章所有信息
    Result getArticleInfoById(Integer id);

    Result getArticleInfoByUserId(Integer userId);

    // 根据作者查询所有文章
    Result listArticlesByAuthorId(Integer authorId);

    Result listArticlesByAuthorIdAndTime(Integer authorId, Long startTime, Long endTime);

    // -----------------------------改------------------------------------------
    // 更新文章收藏数
    Result updateStars(Integer id, Integer star);

    // 更新文章评论数
    Result updateComments(Integer id, Integer comment);

    // 更新文章浏览数
    Result updateVisitors(Integer id, Integer visitor);

    // 更新文章点赞数
    Result updateLikes(Integer id, Integer like);

    // 更新文章公开权限
    Result updateOpen(Integer id, Integer open);

    // 更新文章评论权限
    Result updateComment(Integer id, Integer comment);

    // 更新文章优先级
    Result updatePriority(Integer id, Integer priority);

    // 更新文章最大优先级
    Result updateCurrentMaxPriority(Integer id, Integer currentMaxPriority);

    // 更新文章状态
    Result updateStatus(Integer id, Integer status);

    // 更新最后更新文章的时间
    Result updateLastUpdateTime(Integer id);

    // -----------------------------增------------------------------------------
    // 新增一条文章记录
    Result saveArticleInfo(Integer authorId);
    // -----------------------------删------------------------------------------
}