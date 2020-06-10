package group1.service.impl;

import group1.dao.UserAccountDao;
import group1.feign.ThirdPartyClient;
import group1.service.IUserAccountService;
import group1.util.UserConvert;
import group2.entity.dto.UserAccountDTO;
import group2.entity.pojo.UserAccountDO;
import group2.enums.BindPerfix;
import group2.redis.Cache;
import group2.returnJson.Result;
import group2.returnJson.StatusEnum;
import group2.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 15:35
 * @description:
 **/

@Service
@Slf4j
public class UserAccountServiceImpl implements IUserAccountService {
    @Resource
    Cache cache;//封装cache
    @Resource
    private UserAccountDao userAccountDao;

    @Resource
    private ThirdPartyClient thirdPartyClient;
    @Resource
    private RedisTemplate redisTemplate;

    // 查询根据  id
    public Result getUserAccountById(Integer id) {
        UserAccountDO userAccount = userAccountDao.getUserAccountById(id);
        if (null == userAccount)
            return Result.fail(StatusEnum.NO_OPTION);
        UserAccountDTO userAccountDTO = UserConvert.doToDto(userAccount);
        if (null == userAccountDTO)
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
        log.info("查询用户,id=" + id);
        return Result.success(userAccountDTO);
    }

    // 查询根据  account
    public Result getUserAccountByAccount(String account) {

        UserAccountDO userAccount = userAccountDao.getUserAccountByAccount(account);
        if (null == userAccount)
            return Result.fail(StatusEnum.NO_OPTION);
        UserAccountDTO userAccountDTO = UserConvert.doToDto(userAccount);
        if (null == userAccountDTO)
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
        log.info("查询用户,account=" + account);
        return Result.success(userAccountDTO);
    }

    // 模糊查询根据  name
    public Result<List<UserAccountDTO>> ListUserAccountByName(String name) {
        List<UserAccountDO> doList = userAccountDao.ListUserAccountByName(name);
        List<UserAccountDTO> dtoList = new ArrayList<>();

        if (null == doList || doList.size() < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(userAccountDO -> dtoList.add(UserConvert.doToDto(userAccountDO)));
        return Result.success(dtoList);
    }

    // 模糊查询根据  sex
    public Result<List<UserAccountDTO>> ListUserAccountBySex(String sex) {
        List<UserAccountDO> doList = userAccountDao.ListUserAccountBySex(sex);
        List<UserAccountDTO> dtoList = new ArrayList<>();
        if (null == doList || doList.size() < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(userAccountDO -> dtoList.add(UserConvert.doToDto(userAccountDO)));
        return Result.success(dtoList);
    }

    // 模糊查询根据  registerTime
    public Result<List<UserAccountDTO>> ListUserAccountByTime(Long registerTime) {
        List<UserAccountDO> doList = userAccountDao.ListUserAccountByTime(registerTime);
        List<UserAccountDTO> dtoList = new ArrayList<>();
        if (null == doList || doList.size() < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(userAccountDO -> dtoList.add(UserConvert.doToDto(userAccountDO)));
        return Result.success(dtoList);
    }

    // 模糊查询根据  name sex
    public Result<List<UserAccountDTO>> ListUserAccountByNameAndSex(String name, String sex) {
        List<UserAccountDO> doList = userAccountDao.ListUserAccountByNameAndSex(name, sex);
        List<UserAccountDTO> dtoList = new ArrayList<>();
        if (null == doList || doList.size() < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(useraccountDO -> dtoList.add(UserConvert.doToDto(useraccountDO)));
        return Result.success(dtoList);
    }

    // 模糊查询根据  name registerTime
    public Result<List<UserAccountDTO>> ListUserAccountByNameAndTime(String name, Long registerTime) {
        List<UserAccountDO> doList = userAccountDao.ListUserAccountByNameAndTime(name, registerTime);
        List<UserAccountDTO> dtoList = new ArrayList<>();
        if (null == doList || doList.size() < 0)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(userAccountDO -> dtoList.add(UserConvert.doToDto(userAccountDO)));
        return Result.success(dtoList);
    }

    // 模糊查询根据  sex registerTime
    public Result<List<UserAccountDTO>> ListUserAccountBySexAndTime(String sex, Long registerTime) {
        List<UserAccountDO> dolist = userAccountDao.ListUserAccountBySex(sex);
        List<UserAccountDTO> dtosList = new ArrayList<UserAccountDTO>();
        if (null != dolist && dolist.size() > 0)
            return Result.fail(StatusEnum.NO_OPTION);
        dolist.forEach(userAccountDO -> dtosList.add(UserConvert.doToDto(userAccountDO)));
        return Result.success(dtosList);
    }

    // 模糊查询根据   name  sex registerTime
    public Result<List<UserAccountDTO>> ListUserAccountByNameAndSexAndTime(String name, String sex, Long registerTime) {
        List<UserAccountDO> doList = userAccountDao.ListUserAccountBySex(sex);
        List<UserAccountDTO> dtosList = new ArrayList<>();
        if (null == doList || doList.size() < 0)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(userAccountDO -> dtosList.add(UserConvert.doToDto(userAccountDO)));
        return Result.success(dtosList);
    }

    // 绑定phone
    public Result bindPhone(Integer userId, String phone, String code) {

        Boolean isPass = this.valid(BindPerfix.PHONE.getBindPerfix()+phone, code);

        if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.bindPhone(userId, phone);
        if (size < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }

    //  绑定Email
    public Result bindEmail(Integer userId, String email, String code) {
        Boolean isPass = this.valid(BindPerfix.EMAIL.getBindPerfix()+email, code);
        if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.bindPhone(userId, email);
        if (size < 1)

            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }

    //  绑定Wechat
    public Result bindWeChat(Integer userId, String weChatOpenId, String code) {
        Boolean isPass = this.valid(BindPerfix.WECHAT.getBindPerfix()+weChatOpenId, code);
        if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.bindPhone(userId, weChatOpenId);
        if (size < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }

    //  解绑Phone
    public Result unbindPhone(Integer userId, String code) {
        Boolean isPass = this.valid(BindPerfix.UNPHONE.getBindPerfix()+userId, code);
        if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.unbindPhone(userId);
        if (size < 1)

            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }

    //  解绑Emall
    public Result unbindEmail(Integer userId, String code) {
        Boolean isPass = this.valid(BindPerfix.UNEMAIL.getBindPerfix()+userId, code);
        if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.unbindPhone(userId);
        if (size < 1)

            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }

    //  解绑微信
    public Result unbindWeChat(Integer userId, String code) {

        Boolean isPass = this.valid(BindPerfix.UNWECHAT.getBindPerfix()+userId, code);
        if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.unbindPhone(userId);
        if (size < 1)

            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }

    //更新头像
    public Result updatePicture(Integer userId, String picture) {
        Integer size = userAccountDao.updateName(userId, picture);  //更新头像
        if (size < 1)
            return Result.success(size);

        return Result.fail(StatusEnum.NO_OPTION);
    }

    //更新name
    public Result updateName(Integer userId, String name) {
        UserAccountDO userAccount = userAccountDao.getUserAccountById(userId);
        if (userAccount == null)
            return Result.fail(StatusEnum.NO_OPTION);  //查无此人

        //  新旧用户
        if (userAccount.getName() != name)
            return Result.fail(StatusEnum.NOT_FOUND);  //name 不一致

        Integer size = userAccountDao.updateName(userId, name);  //更新name
        if (size == 1)
            return Result.success(size);

        return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
    }

    //更新密码
    public Result updatePassword(Integer userId, String oldPassword, String newPassword, String code) {
        Boolean isPass = this.valid(BindPerfix.PASSWORD.getBindPerfix()+userId, code);
        if (!isPass) return Result.fail(StatusEnum.NO_OPTION);

        UserAccountDO userAccount = userAccountDao.getUserAccountById(userId);
        if (userAccount == null)
            return Result.fail(StatusEnum.NO_OPTION);  //查无此人

        //  新旧密码不一致
        if (userAccount.getPassword() != oldPassword)
            return Result.fail(StatusEnum.NOT_FOUND); //密码不一致

        Integer size = userAccountDao.updatePassword(userId, newPassword);
        if (size > 0)
            return Result.success(size);

        return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
    }

    //更新电话
    public Result updatePhone(Integer userId, String oldPhone, String newPhone, String oldPhoneCode, String newPhoneCode) {

        UserAccountDO userAccount = userAccountDao.getUserAccountById(userId);
        if (userAccount == null)
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);  //查无此人

        //  新旧电话不一致
        if (userAccount.getPhone() != oldPhone)
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);

        Integer size = userAccountDao.updatePassword(userId, newPhone);
        if (size > 0)
            return Result.success(size);

        return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
    }

    public Result updateEmail(Integer userId, String oldEmail, String newEmail, String oldEmailCode, String newEmailCode) {
        return null;
    }


    public Result saveUserAccount(String account, String password) {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password))
            return Result.fail(StatusEnum.NO_OPTION);
        // 1、account是否重复？
        // ...
        String passwordMD5 = MD5Util.string2MD5(password);
        // 2、插入account、password返回新增记录的id
        // 测试MD5加密
        log.info("原始密码：" + password);
        log.info("MD5加密后：" + passwordMD5);

        if (StringUtils.isEmpty(passwordMD5))
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);

        UserAccountDO userAccount = UserConvert.getDo(account, passwordMD5);
        if (null == userAccount)
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);

        Integer i = userAccountDao.saveUserAccount(userAccount);
        Integer id = userAccount.getId();
        if (i == 1 && id > 0) {
            log.info("插入新用户成功:\t" + userAccount.toString());
            return Result.success(id);
        } else {
            log.info("插入新用户失败:\t" + userAccount.toString());
            return Result.fail();
        }
    }


    public Object test1(Object obj) {
        return thirdPartyClient.sendMail((String) obj);
    }


    public Object test2(Object obj) {
        return null;
    }

    //  生成code[可用于手机，邮箱]
    public String createCode(String obj) {
        String valCode = String.valueOf((int) ((Math.random() * 9 + 1) * 1000));  // 默认随机四位小数
        cache.put(obj, valCode, 200);
        return valCode;
    }

    // 基于redis 取数据返回值true和false
     Boolean valid(String obj, String code) {
        Object valcode = cache.get(obj);
        if (null != valcode && valcode.toString().equals(valcode)) {
            cache.remove(obj);
            return true;
        }
        return false;
    }

}