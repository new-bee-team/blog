package group1.dao;

import group2.entity.pojo.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserInfoDao {
    //-------------------查----------------------
    //-------------------增----------------------
    Integer saveUserInfo(UserInfoDO userInfoDO);
    //-------------------改----------------------
    //-------------------删----------------------
}
