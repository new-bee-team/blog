package group1.service.impl;

import group1.service.IUserScoreService;
import group2.entity.vo.UserScoreVO;
import group2.returnJson.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: KongKongBaby
 * @create: 2020-06-04 17:27
 * @description: 用户积分服务
 **/

@Service
@Slf4j
public class UserScoreServiceImpl implements IUserScoreService {
    @Override
    public Result saveScore(UserScoreVO userScoreVO) {
        return null;
    }

    @Override
    public Result listScoreByTime(Integer userId, Boolean isDesc, Integer startPage, Integer pageSize) {
        return null;
    }

    @Override
    public Result getTotalScore(Integer userId) {
        return null;
    }
}
