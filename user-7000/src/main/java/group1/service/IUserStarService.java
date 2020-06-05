package group1.service;

import group2.returnJson.Result;

/**
 * @author: jiacheng.xing
 * @Date: 2020.06.05 22:12
 * @Description: 用户收藏文章相关服务
 */

public interface IUserStarService {
    // -----------------查----------------------
    // 用户收藏的文章 desc=true: 时间从新到旧排列 反之
    Result listStarArticle(Integer userId, Boolean desc, Integer startPage, Integer pageInfo);

    // 根据文章id查询细节
    Result getStarArticle(Integer articleId);

    // -----------------增----------------------
    Result saveStarArticle(Integer userId, Integer articleId);

    // -----------------删----------------------
    // -----------------改----------------------
    // 修改status
    Result deleteStarArticle(Integer userId, Integer articleId);
}
