package group1.dao;

import group2.entity.pojo.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface GetUserAccountDao {
    UserAccount getUserAccountById(Integer id);
}