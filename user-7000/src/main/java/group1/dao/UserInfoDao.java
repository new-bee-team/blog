package group1.dao;

import group2.entity.pojo.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserInfoDao {
    //-------------------查----------------------
    UserInfoDO getUserInfo(Integer userId);

    //-------------------增----------------------
    Integer saveUserInfo(UserInfoDO userInfoDO);

    //-------------------改----------------------
    //用户登录 增加积分、经验，更新最后登录时间
    Integer updateUserEarnings(@Param("userId") Integer userId, @Param("scoreLogin") Integer scoreLogin, @Param("experienceLogin") Integer experienceLogin, @Param("currentTimeMillis") Long currentTimeMillis);


    //-------------------删----------------------
}
