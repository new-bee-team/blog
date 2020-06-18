package group1.service.impl;

import group1.dao.UserAccountDao;
import group1.dao.UserInfoDao;
import group1.feign.ThirdPartyClient;
import group1.service.IUserInfoService;
import group1.util.UserConvertUtil;
import group2.entity.dto.UserDTO;
import group2.entity.pojo.UserAccountDO;
import group2.entity.pojo.UserInfoDO;
import group2.returnJson.Result;
import group2.returnJson.StatusEnum;
import group2.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    @Resource
    private RedisTemplate<String,String> redisTemplate;

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
    public Result userLogin(String pass, String command, Integer type) {
        UserDTO userDTO;
        // 帐号密码登录
        if (type == 1) {
            UserAccountDO userAccountByAccount = userAccountDao.getUserAccountByAccount(pass);
            if (null != userAccountByAccount && (MD5Util.string2MD5(command)).equals(userAccountByAccount.getPassword())) {
                // 记录历史 xxx
                UserInfoDO userInfo = userInfoDao.getUserInfo(userAccountByAccount.getId());
                if (null != userInfo) {
                    userDTO = UserConvertUtil.doToDto(userAccountByAccount, userInfo);
                    return Result.success(userDTO);
                }
            }
        }
        // 邮箱登录
        if (type == 2) {
            String code = redisTemplate.opsForValue().get(pass);
            Boolean isPass = command.equals(code);
            if (isPass) {
                UserAccountDO userAccountByEmail = userAccountDao.getUserAccountByEmail(pass);
                if (null != userAccountByEmail) {
                    // 记录历史 xxx
                    UserInfoDO userInfo = userInfoDao.getUserInfo(userAccountByEmail.getId());
                    userDTO = UserConvertUtil.doToDto(userAccountByEmail, userInfo);
                    return Result.success(userDTO);
                }
            }
        }
        // 手机登陆
        if (type == 3) {
            return Result.fail(StatusEnum.BAD_METHOD, "开发中");
        }
        // 微信小程序登录
        if (type == 4) {
            return Result.fail(StatusEnum.BAD_METHOD, "开发中");
        }
        return Result.fail(StatusEnum.INTERNAL_SERVER_ERROR,"登录失败");
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
