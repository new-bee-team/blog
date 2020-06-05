package group1.service;

import group2.returnJson.Result;

/**
 * @author: jiacheng.xing
 * @Date: 2020.06.05 22:15
 * @Description: 用户经验值相关
 */

public interface IUserExperienceService {

    //-------------------查--------------------------
    // 查询总经验值
    Result getTotalExperience(Integer userId);

    // 查询经验值细节
    Result listDetailExperience(Integer userId, Integer startPage, Integer pageSize);

    //-------------------改--------------------------
    // 增加经验值
    Result increaseExperience(Integer userId, Integer experience);
}