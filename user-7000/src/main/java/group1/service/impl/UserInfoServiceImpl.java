package group1.service.impl;

import group1.service.IUserInfoService;
import group2.returnJson.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-06-04 17:27
 * @description:
 **/

@Service
@Slf4j
public class UserInfoServiceImpl implements IUserInfoService {
    @Override
    public Result getUserInfoById(Integer id) {
        return null;
    }

    @Override
    public Result getUserInfoByUserId(Integer userId) {
        return null;
    }

    @Override
    public Result updateFollower(Integer userId, Integer follower, Boolean add) {
        return null;
    }

    @Override
    public Result updateVisitor(Integer userId, Integer visitor, Boolean add) {
        return null;
    }

    @Override
    public Result updateComment(Integer userId, Integer comments, Boolean add) {
        return null;
    }

    @Override
    public Result updateScore(Integer userId, Integer score, Boolean add) {
        return null;
    }

    @Override
    public Result updateExperience(Integer userId, Integer experience, Boolean add) {
        return null;
    }

    @Override
    public Result updateLastLoginTime(Integer userId) {
        return null;
    }

    @Override
    public Result saveUserInfo(Integer userId) {
        return null;
    }
}
