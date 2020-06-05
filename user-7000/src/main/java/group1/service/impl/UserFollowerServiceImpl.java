package group1.service.impl;

import group1.service.IUserFollowerService;
import group2.returnJson.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-06-04 17:26
 * @description:
 **/

@Service
@Slf4j
public class UserFollowerServiceImpl implements IUserFollowerService {
    @Override
    public Result listMyFollow(Integer followerId, Integer startPage, Integer pageSize) {
        return null;
    }

    @Override
    public Result followBlogger(Integer followerId, Integer bloggerId) {
        return null;
    }

    @Override
    public Result cancelFollow(Integer followerId, Integer bloggerId) {
        return null;
    }

    @Override
    public Result reFollow(Integer followerId, Integer bloggerId) {
        return null;
    }
}
