package group1.service.impl;

import group1.service.IUserExperienceService;
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
public class UserExperienceServiceImpl implements IUserExperienceService {
    @Override
    public Result getTotalExperience(Integer userId) {
        return null;
    }

    @Override
    public Result listDetailExperience(Integer userId, Integer startPage, Integer pageSize) {
        return null;
    }

    @Override
    public Result increaseExperience(Integer userId, Integer experience) {
        return null;
    }
}
