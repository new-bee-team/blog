package group1.dao;

import group2.entity.pojo.UserAccountDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAccountDao {

    //----------------------查----------------------
    // 根据id精确查询用户
    UserAccountDO getUserAccountById(@Param("id") Integer id);

    // 根据account精确查询用户
    UserAccountDO getUserAccountByAccount(@Param("account") String account);

    // 根据name模糊查询
    List<UserAccountDO> ListUserAccountByName(@Param("name") String name);

    // 根据sex模糊查询
    List<UserAccountDO> ListUserAccountBySex(@Param("sex") String sex);

    // 根据registerTime模糊查询
    List<UserAccountDO> ListUserAccountByTime(@Param("registerTime") Long registerTime);

    // 根据 name + sex 模糊查询
    List<UserAccountDO> ListUserAccountByNameAndSex(@Param("name") String name, @Param("sex") String sex);

    // 根据 name + registerTime模糊查询
    List<UserAccountDO> ListUserAccountByNameAndTime(@Param("name") String name, @Param("registerTime") Long registerTime);

    // 根据 sex + registerTime模糊查询
    List<UserAccountDO> ListUserAccountBySexAndTime(@Param("sex") String sex, @Param("registerTime") Long registerTime);

    // 根据 name + sex + registerTime模糊查询
    List<UserAccountDO> ListUserAccountByNameAndSexAndTime(@Param("name") String name, @Param("sex") String sex, @Param("registerTime") Long registerTime);

    //----------------------改----------------------
    // 绑定手机
    Integer bindPhone(@Param("userId") Integer userId, @Param("phone") String phone);

    // 绑定邮箱
    Integer bindEmail(@Param("userId") Integer userId, @Param("email") String email);

    // 绑定微信
    Integer bindWeChat(@Param("userId") Integer userId, @Param("weChatOpenId") String weChatOpenId);

    // 解绑手机
    Integer unbindPhone(@Param("userId") Integer userId);

    // 解绑邮箱
    Integer unbindEmail(@Param("userId") Integer userId);

    // 解绑微信
    Integer unbindWeChat(@Param("userId") Integer userId);

    // 修改头像
    Integer updatePicture(@Param("userId") Integer userId, @Param("picture") String picture);

    // 修改用户名name不是account
    Integer updateName(@Param("userId") Integer userId, @Param("name") String name);

    // 修改密码 code包括手机或邮箱都可以
    Integer updatePassword(@Param("userId") Integer userId, @Param("newPassword") String newPassword);

    // 修改手机 code必须是手机验证码
    Integer updatePhone(@Param("userId") Integer userId, @Param("newPhone") String newPhone);

    // 修改邮箱
    Integer updateEmail(@Param("userId") Integer userId, @Param("newEmail") String newEmail);

    //----------------------增----------------------
    // 注册用户
    Integer saveUserAccount(UserAccountDO userAccountDO);

    //----------------------删----------------------
}