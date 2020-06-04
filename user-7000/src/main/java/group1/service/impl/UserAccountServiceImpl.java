package group1.service.impl;

import group1.dao.UserAccountDao;
import group1.feign.ThirdPartyClient;
import group1.service.IUserAccountService;
import group1.util.Convert;
import group2.entity.dto.UserAccountDTO;
import group2.entity.pojo.UserAccountDO;
import group2.entity.vo.UserAccountVO;
import group2.returnJson.Result;
import group2.returnJson.StatusEnum;
import group2.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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
    private UserAccountDao userAccountDao;

    @Resource
    private ThirdPartyClient thirdPartyClient;

    @Override
    public Result getUserAccountById(Integer id) {
        UserAccountDO userAccount = userAccountDao.getUserAccountById(id);
        if (null == userAccount)
            return Result.fail(StatusEnum.NO_OPTION);
        UserAccountDTO userAccountDTO = Convert.doToDto(userAccount);
        if (null == userAccountDTO)
            return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
        log.info("查询用户,id=" + id);
        return Result.success(userAccountDTO);
    }

    @Override
    public Result getUserAccountByAccount(String account) {
        return null;
    }

    @Override
    public List<Result> ListUserAccountByName(String name) {
        return null;
    }

    @Override
    public List<Result> ListUserAccountBySex(String sex) {
        return null;
    }

    @Override
    public List<Result> ListUserAccountByTime(Long registerTime) {
        return null;
    }


    @Override
    public List<Result> ListUserAccountByNameAndSex(String name, String sex) {
        return null;
    }

    @Override
    public List<Result> ListUserAccountByNameAndTime(String name, Long registerTime) {
        return null;
    }

    @Override
    public List<Result> ListUserAccountBySexAndTime(String sex, Long registerTime) {
        return null;
    }

    @Override
    public List<Result> ListUserAccountByNameAndSexAndTime(String name, String sex, Long registerTime) {
        return null;
    }

    @Override
    public Result bindPhone(Integer userId, String phone, String code) {
        return null;
    }

    @Override
    public Result bindEmail(Integer userId, String email, String code) {
        return null;
    }

    @Override
    public Result bindWeChat(Integer userId, String weChatOpenId, String code) {
        return null;
    }

    @Override
    public Result unbindPhone(Integer userId, String code) {
        return null;
    }

    @Override
    public Result unbindEmail(Integer email, String code) {
        return null;
    }

    @Override
    public Result unbindWeChat(Integer wechatOpenId, String code) {
        return null;
    }

    @Override
    public Result updatePicture(Integer userId, String picture) {
        return null;
    }

    @Override
    public Result updateName(Integer userId, String name) {
        return null;
    }

    @Override
    public Result updatePassword(Integer userId, String oldPassword, String newPassword, String code) {
        return null;
    }

    @Override
    public Result updatePhone(Integer userId, String oldPhone, String newPhone, String oldPhoneCode, String newPhoneCode) {
        return null;
    }

    @Override
    public Result updateEmail(Integer userId, String oldEmail, String newEmail, String oldEmailCode, String newEmailCode) {
        return null;
    }

    @Override
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

        UserAccountDO userAccount = Convert.getDo(account, passwordMD5);
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

    @Override
    public Object test1(Object obj) {
        return thirdPartyClient.sendMail((String) obj);
    }

    @Override
    public Object test2(Object obj) {
        return null;
    }

}