package group1.dao;

import group2.entity.pojo.UserAccountDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFollowerDao {
    //----------------------查----------------------
    // 查询我关注的所有博主
    List<UserAccountDO> listMyFollow(Integer followerId, Integer startPage, Integer pageSize);

    //----------------------增----------------------
    // 关注博主
    Integer saveFollowBlogger(Integer followerId, Integer bloggerId);

    //----------------------改----------------------
    // 取消关注
    Integer updateFollow(Integer followerId, Integer bloggerId);

    // 取消取消关注
    Integer reFollow(Integer followerId, Integer bloggerId);
}
