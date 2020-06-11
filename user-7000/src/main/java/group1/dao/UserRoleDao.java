package group1.dao;

import group2.entity.pojo.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleDao {
    UserRoleDO getUserRole(Integer userId);
}
