package group1.service.impl;

import group1.dao.UserAccountDao;
import group1.dao.UserInfoDao;
import group1.feign.ThirdPartyClient;
import group1.service.IUserInfoService;
import group1.util.UserConvert;
import group2.entity.dto.UserDTO;
import group2.entity.pojo.UserAccountDO;
import group2.entity.pojo.UserInfoDO;
import group2.returnJson.Result;
import group2.returnJson.StatusEnum;
import group2.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: KongKongBaby
 * @create: 2020-06-04 17:27
 * @description:
 **/

@Service
@Slf4j
public class UserInfoServiceImpl implements IUserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Resource
    private UserAccountDao userAccountDao;

    @Resource
    private ThirdPartyClient thirdPartyClient;

    @Override
    public Result getUserInfoById(Integer id) {
        return null;
    }

    @Override
    public Result getUserInfoByUserId(Integer userId) {
        return null;
    }

    @Override
    @Transactional
    public Result userLogin(String pass, String command, Integer type, String codeKey) {
        UserDTO userDTO;
        if (type == 1 && codeKey.equals("0000")) {
            UserAccountDO userAccountByAccount = userAccountDao.getUserAccountByAccount(pass);
            if (null != userAccountByAccount && (MD5Util.string2MD5(command)).equals(userAccountByAccount.getPassword())) {
                // 记录历史 xxx
                UserInfoDO userInfo = userInfoDao.getUserInfo(userAccountByAccount.getId());
                if (null != userInfo) {
                    userDTO = UserConvert.doToDto(userAccountByAccount, userInfo);
                    return Result.success(userDTO);
                }
            }
        }
        if (type == 2 && !codeKey.equals("0000")) {
            Boolean isPass = thirdPartyClient.checkCode(codeKey, command);
            if (isPass) {
                UserAccountDO userAccountByEmail = userAccountDao.getUserAccountByEmail(pass);
                if (null != userAccountByEmail) {
                    // XXX
                    UserInfoDO userInfo = userInfoDao.getUserInfo(userAccountByEmail.getId());
                    userDTO = UserConvert.doToDto(userAccountByEmail, userInfo);
                    return Result.success(userDTO);
                }
            }
        }
        if (type == 3 && !codeKey.equals("0000")) {
            return Result.fail(StatusEnum.BAD_METHOD, "开发中");
        }
        if (type == 4 && codeKey.equals("0000")) {
            return Result.fail(StatusEnum.BAD_METHOD, "开发中");
        }
        return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR);
    }

    @Override
    public Result updateFollower(Integer userId, Integer follower, Boolean add) {
        return null;
    }

    @Override
    public Result updateVisitor(Integer userId, Integer visitor, Boolean add) {
        return null;
    }

    @Override
    public Result updateComment(Integer userId, Integer comments, Boolean add) {
        return null;
    }

    @Override
    public Result updateScore(Integer userId, Integer score, Boolean add) {
        return null;
    }

    @Override
    public Result updateExperience(Integer userId, Integer experience, Boolean add) {
        return null;
    }

    @Override
    public Result updateLastLoginTime(Integer userId) {
        return null;
    }

    @Override
    public Result saveUserInfo(Integer userId) {
        return null;
    }
}
