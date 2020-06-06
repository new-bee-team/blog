package group1.service;

import group2.entity.dto.UserAccountDTO;
import group2.entity.pojo.UserAccountDO;
import group2.returnJson.Result;

import java.util.List;

public interface IUserAccountService {

    //----------------------查----------------------
    // 根据id精确查询用户
    Result getUserAccountById(Integer id);

    // 根据account精确查询用户
    Result getUserAccountByAccount(String account);

    Result<List<UserAccountDTO>>  ListUserAccountByName(String name);

    // 根据sex模糊查询
    Result<List<UserAccountDTO>> ListUserAccountBySex(String sex);

    // 根据registerTime模糊查询
    Result<List<UserAccountDTO>>  ListUserAccountByTime(Long registerTime);

    // 根据 name + sex 模糊查询
    Result<List<UserAccountDTO>>  ListUserAccountByNameAndSex(String name, String sex);

    // 根据 name + registerTime模糊查询
    Result<List<UserAccountDTO>>  ListUserAccountByNameAndTime(String name, Long registerTime);

    // 根据 sex + registerTime模糊查询
    Result<List<UserAccountDTO>>  ListUserAccountBySexAndTime(String sex, Long registerTime);

    // 根据 name + sex + registerTime模糊查询
    Result<List<UserAccountDTO>> ListUserAccountByNameAndSexAndTime(String name, String sex, Long registerTime);

    //----------------------改----------------------
    // 绑定手机
    Result bindPhone(Integer userId, String phone, String code);

    // 绑定邮箱
    Result bindEmail(Integer userId, String email, String code);

    // 绑定微信
    Result bindWeChat(Integer userId, String weChatOpenId, String code);

    // 解绑手机
    Result unbindPhone(Integer userId, String code);

    // 解绑邮箱
    Result unbindEmail(Integer userId, String code);

    // 解绑微信
    Result unbindWeChat(Integer userId, String code);

    // 修改头像
    Result updatePicture(Integer userId, String picture);

    // 修改用户名name不是account
    Result updateName(Integer userId, String name);

    // 修改密码 code包括手机或邮箱都可以
    Result updatePassword(Integer userId, String oldPassword, String newPassword, String code);

    // 修改手机 code必须是手机验证码
    Result updatePhone(Integer userId, String oldPhone, String newPhone, String oldPhoneCode, String newPhoneCode);

    // 修改邮箱
    Result updateEmail(Integer userId, String oldEmail, String newEmail, String oldEmailCode, String newEmailCode);

    //----------------------增----------------------
    // 注册用户
    Result saveUserAccount(String account, String password);

    //----------------------删----------------------

    //----------------------其他----------------------
    // 测试1
    Object test1(Object obj);

    // 测试2
    Object test2(Object obj);
}
