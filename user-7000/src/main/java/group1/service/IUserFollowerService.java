package group1.service;

import group2.returnJson.Result;

public interface IUserFollowerService {
    //----------------------查----------------------
    // 查询我关注的所有博主
    Result listMyFollow(Integer followerId, Integer startPage, Integer pageSize);

    //----------------------增----------------------
    // 关注博主
    Result followBlogger(Integer followerId, Integer bloggerId);

    //----------------------改----------------------
    // 取消关注
    Result cancelFollow(Integer followerId, Integer bloggerId);

    // 取消取消关注
    Result reFollow(Integer followerId, Integer bloggerId);
}