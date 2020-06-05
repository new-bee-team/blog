package group1.service;

import group2.returnJson.Result;

public interface IUserInfoService {
    //-------------------查-------------------------
    // 查询总的信息
    Result getUserInfoById(Integer id);

    Result getUserInfoByUserId(Integer userId);

    //-------------------增-------------------------

    //-------------------改-------------------------
    // Boolean add: true增加  false减少
    // 更新被关注数
    Result updateFollower(Integer userId, Integer follower, Boolean add);

    // 更新访客数
    Result updateVisitor(Integer userId, Integer visitor, Boolean add);

    // 更新评论数
    Result updateComment(Integer userId, Integer comments, Boolean add);

    // 更新积分
    Result updateScore(Integer userId, Integer score, Boolean add);

    // 更新经验
    Result updateExperience(Integer userId, Integer experience, Boolean add);

    // 更新最近登录时间
    Result updateLastLoginTime(Integer userId);

    //-------------------增-------------------------
    // 用户注册时，增加对应记录
    Result saveUserInfo(Integer userId);

}
