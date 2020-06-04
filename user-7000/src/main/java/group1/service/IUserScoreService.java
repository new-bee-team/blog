package group1.service;

import group2.entity.vo.UserScoreVO;
import group2.returnJson.Result;

public interface IUserScoreService {
    //----------------------增----------------------
    // 增加或扣除积分 (必须成功，失败记录日志)
    Result saveScore(UserScoreVO userScoreVO);
    //----------------------查----------------------
    // isDesc是否降序排列（根据时间）默认是按时间倒序排列
    Result listScoreByTime(Integer userId,Boolean isDesc,Integer startPage,Integer pageSize);

    // 查询用户总积分
    Result getTotalScore(Integer userId);
    //----------------------改----------------------
    //----------------------删----------------------
}
