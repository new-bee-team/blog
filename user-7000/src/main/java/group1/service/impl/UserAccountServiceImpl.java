package group1.service.impl;

import group1.dao.UserAccountDao;
import group1.dao.UserInfoDao;
import group1.feign.ThirdPartyClient;
import group1.service.IUserAccountService;
import group1.util.UserConvert;
import group2.entity.dto.UserAccountDTO;
import group2.entity.pojo.UserAccountDO;
import group2.entity.pojo.UserInfoDO;
import group2.enums.BindPerfix;
import group2.page.PageBean;
import group2.redis.Cache;
import group2.returnJson.Result;
import group2.returnJson.StatusEnum;
import group2.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    private Cache cache;//封装cache

    @Resource
    private UserAccountDao userAccountDao;

    @Resource
    private UserInfoDao userInfoDao;

    @Resource
    private ThirdPartyClient thirdPartyClient;


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
    public Result ListUserAccountByName(String name, Integer startPage, Integer pageSize) {
        int start = startPage <= 1 ? 1 : startPage;
        int startRow = (start - 1) * pageSize;

        List<UserAccountDO> doList = userAccountDao.ListUserAccountByName(name, startRow, pageSize);
        List<UserAccountDTO> dtoList = new ArrayList<>();

        if (null == doList || doList.size() < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(userAccountDO -> dtoList.add(UserConvert.doToDto(userAccountDO)));
        Integer totalPages = userAccountDao.countUserAccountByName(name);
        return Result.success(new PageBean<>(startPage, pageSize, totalPages, dtoList));
    }

    // 模糊查询根据  sex
    public Result ListUserAccountBySex(String sex, Integer startPage, Integer pageSize) {
        int start = startPage <= 1 ? 1 : startPage;
        int startRow = (start - 1) * pageSize;
        List<UserAccountDO> doList = userAccountDao.ListUserAccountBySex(sex, startRow, pageSize);
        List<UserAccountDTO> dtoList = new ArrayList<>();
        if (null == doList || doList.size() < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(userAccountDO -> dtoList.add(UserConvert.doToDto(userAccountDO)));
        Integer totalPages = userAccountDao.countUserAccountBySex(sex);
        return Result.success(new PageBean<>(startPage, pageSize, totalPages, dtoList));
    }

    // 模糊查询根据  registerTime
    public Result ListUserAccountByTime(Long startTime, Long endTime, Integer startPage, Integer pageSize) {
        int start = startPage <= 1 ? 1 : startPage;
        int startRow = (start - 1) * pageSize;
        List<UserAccountDO> doList = userAccountDao.ListUserAccountByTime(startTime, endTime, startRow, pageSize);
        List<UserAccountDTO> dtoList = new ArrayList<>();
        if (null == doList || doList.size() < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(userAccountDO -> dtoList.add(UserConvert.doToDto(userAccountDO)));
        Integer totalPages = userAccountDao.countUserAccountByTime(startTime, endTime);
        return Result.success(new PageBean<>(startPage, pageSize, totalPages, dtoList));
    }

    // 模糊查询根据  name sex
    public Result ListUserAccountByNameAndSex(String name, String sex, Integer startPage, Integer pageSize) {
        int start = startPage <= 1 ? 1 : startPage;
        int startRow = (start - 1) * pageSize;
        List<UserAccountDO> doList = userAccountDao.ListUserAccountByNameAndSex(name, sex, startRow, pageSize);
        List<UserAccountDTO> dtoList = new ArrayList<>();
        if (null == doList || doList.size() < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(useraccountDO -> dtoList.add(UserConvert.doToDto(useraccountDO)));
        Integer totalPages = userAccountDao.countUserAccountByNameAndSex(name, sex);
        return Result.success(new PageBean<>(startPage, pageSize, totalPages, dtoList));
    }

    // 模糊查询根据  name registerTime
    public Result ListUserAccountByNameAndTime(String name, Long startTime, Long endTime, Integer startPage, Integer pageSize) {
        int start = startPage <= 1 ? 1 : startPage;
        int startRow = (start - 1) * pageSize;
        List<UserAccountDO> doList = userAccountDao.ListUserAccountByNameAndTime(name, startTime, endTime, startRow, pageSize);
        List<UserAccountDTO> dtoList = new ArrayList<>();
        if (null == doList || doList.size() < 0)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(userAccountDO -> dtoList.add(UserConvert.doToDto(userAccountDO)));
        Integer totalPages = userAccountDao.countUserAccountByNameAndTime(name, startTime, endTime);
        return Result.success(new PageBean<>(startPage, pageSize, totalPages, dtoList));
    }

    // 模糊查询根据  sex registerTime
    public Result ListUserAccountBySexAndTime(String sex, Long startTime, Long endTime, Integer startPage, Integer pageSize) {
        int start = startPage <= 1 ? 1 : startPage;
        int startRow = (start - 1) * pageSize;
        List<UserAccountDO> dolist = userAccountDao.ListUserAccountBySexAndTime(sex, startTime, endTime, startRow, pageSize);
        List<UserAccountDTO> dtoList = new ArrayList<>();
        if (null != dolist && dolist.size() > 0)
            return Result.fail(StatusEnum.NO_OPTION);
        dolist.forEach(userAccountDO -> dtoList.add(UserConvert.doToDto(userAccountDO)));
        Integer totalPages = userAccountDao.countUserAccountBySexAndTime(sex, startTime, endTime);
        return Result.success(new PageBean<>(startPage, pageSize, totalPages, dtoList));
    }

    // 模糊查询根据   name  sex registerTime
    public Result ListUserAccountByNameAndSexAndTime(String name, String sex, Long startTime, Long endTime, Integer startPage, Integer pageSize) {
        int start = startPage <= 1 ? 1 : startPage;
        int startRow = (start - 1) * pageSize;
        List<UserAccountDO> doList = userAccountDao.ListUserAccountByNameAndSexAndTime(name, sex, startTime, endTime, startRow, pageSize);
        List<UserAccountDTO> dtoList = new ArrayList<>();
        if (null == doList || doList.size() < 0)
            return Result.fail(StatusEnum.NO_OPTION);
        doList.forEach(userAccountDO -> dtoList.add(UserConvert.doToDto(userAccountDO)));
        Integer totalPages = userAccountDao.countUserAccountByNameAndSexAndTime(name, sex, startTime, endTime);
        return Result.success(new PageBean<>(startPage, pageSize, totalPages, dtoList));
    }

    // 绑定phone
    public Result bindPhone(Integer userId, String phone, String code,HttpServletRequest request) {
        Boolean isPass = this.thirdPartyClient.checkCode(code, request);

//        Boolean isPass = this.valid(BindPerfix.PHONE.getBindPerfix() + phone, code);
//
       if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.bindPhone(userId, phone);
        if (size < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }

    //  绑定Email
    public Result bindEmail(Integer userId, String email, String code,HttpServletRequest request) {
        Boolean isPass = this.thirdPartyClient.checkCode(code, request);
//        Boolean isPass = this.valid(BindPerfix.EMAIL.getBindPerfix() + email, code);
     if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.bindPhone(userId, email);
        if (size < 1)

            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }

    //  绑定Wechat
    public Result bindWeChat(Integer userId, String weChatOpenId, String code,HttpServletRequest request) {
        Boolean isPass = this.thirdPartyClient.checkCode(code, request);
//        Boolean isPass = this.valid(BindPerfix.WECHAT.getBindPerfix() + weChatOpenId, code);
      if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.bindPhone(userId, weChatOpenId);
        if (size < 1)
            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }



    //  解绑Phone
    public Result unbindPhone(Integer userId, String code,HttpServletRequest request) {
        Boolean isPass = this.thirdPartyClient.checkCode(code, request);
//        Boolean isPass = this.valid(BindPerfix.UNPHONE.getBindPerfix() + userId, code);
       if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.unbindPhone(userId);
        if (size < 1)

            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }

    //  解绑Emall
    public Result unbindEmail(Integer userId, String code,HttpServletRequest request) {
        Boolean isPass = this.thirdPartyClient.checkCode(code, request);
// Boolean isPass = this.valid(BindPerfix.UNEMAIL.getBindPerfix() + userId, code);
   if (!isPass) return Result.fail(StatusEnum.NO_OPTION);
        Integer size = userAccountDao.unbindPhone(userId);
        if (size < 1)

            return Result.fail(StatusEnum.NO_OPTION);
        return Result.success(size);
    }

    //  解绑微信
    public Result unbindWeChat(Integer userId, String code,HttpServletRequest request) {
        Boolean isPass = this.thirdPartyClient.checkCode(code, request);
//        Boolean isPass = this.valid(BindPerfix.UNWECHAT.getBindPerfix() + userId, code);
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

//    @Override
//    public Result updatePassword(Integer userId, String oldPassword, String newPassword, String code,) {
//        return null;
//    }

    //更新密码
    public Result updatePassword(Integer userId, String oldPassword, String newPassword, String code,HttpServletRequest request) {
        Boolean isPass = this.thirdPartyClient.checkCode(code, request);
//      Boolean isPass = this.valid(BindPerfix.PASSWORD.getBindPerfix() + userId, code);
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


    @Transactional
    public Result saveUserAccount(String account, String password) {
        // 1、account是否重复？
        // ...
        //用户名重复
        UserAccountDO userAccountDo = userAccountDao.getUserAccountByAccount(account);
        if (null != userAccountDo)
            return Result.fail(StatusEnum.USERNAMEREPEAT);

        // 2、插入account、password返回新增记录的id

        String passwordMD5 = MD5Util.string2MD5(password);
        // 测试MD5加密
        log.info("原始密码：" + password);
        log.info("MD5加密后：" + passwordMD5);

        if (StringUtils.isEmpty(passwordMD5))
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);

        UserAccountDO userAccount = UserConvert.getDo(account, passwordMD5);
        if (null == userAccount)
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);

        Integer userAccountChangeRow = userAccountDao.saveUserAccount(userAccount);
        Integer userAccountId = userAccount.getId();

        if (userAccountChangeRow != 1 || userAccountId < 1) {
            log.info("插入用户账户失败:\t" + userAccount.toString());
            return Result.fail(StatusEnum.DATABASE_ERROR);
        }

        // user_account插入成功后 再插入user_info
        UserInfoDO userInfoDO = new UserInfoDO(null, userAccountId, 0, 0, 0, 0, 0, System.currentTimeMillis());

        Integer userInfoChangeRow = userInfoDao.saveUserInfo(userInfoDO);

        if (userInfoChangeRow != 1) {
            log.info("插入用户信息失败:\t" + userInfoDO.toString());
            return Result.fail(StatusEnum.DATABASE_ERROR);
        }

        log.info("用户注册成功");
        return Result.success(userAccountId);
    }

    //用户登录
    @Transactional
    public Result Login(String account, String password) {
        UserAccountDO userAccountDO = userAccountDao.getUserAccountByAccount(account);
        if (userAccountDO == null)

            return null;

        if (userAccountDO.getPassword().equals(MD5Util.string2MD5(password))) {
            //登录成功
            // 更新积分  积分＋1
            userInfoDao.updateUserInfo(userAccountDO.getId(),System.currentTimeMillis());
         //   cache.put(userAccountDO.getId());
            return null;
        }
        return null;

    }

//    //  生成code[可用于手机，邮箱]
//    private String createCode(String obj) {
//        String valCode = String.valueOf((int) ((Math.random() * 9 + 1) * 1000));  // 默认随机四位小数
//        cache.put(obj, valCode, 200);
//        return valCode;
//    }
//
//    // 基于redis 取数据返回值true和false
//    private Boolean valid(String obj, String code) {
//        Object valcode = cache.get(obj);
//        if (null != valcode && valcode.toString().equals(valcode)) {
//            cache.remove(obj);
//            return true;
//        }
//        return false;
//    }

}