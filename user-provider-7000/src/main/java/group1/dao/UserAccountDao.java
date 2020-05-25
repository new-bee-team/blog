package group1.dao;

import group2.entity.pojo.UserAccountDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserAccountDao {
    UserAccountDO getUserAccountById(@Param("id") Integer id);

    Integer saveUserAccount(UserAccountDO userAccount);
}