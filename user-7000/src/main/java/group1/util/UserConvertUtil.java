package group1.util;

import group2.entity.dto.UserAccountDTO;
import group2.entity.dto.UserAccountFriendDTO;
import group2.entity.dto.UserDTO;
import group2.entity.pojo.UserAccountDO;
import group2.entity.pojo.UserExperienceDO;
import group2.entity.pojo.UserInfoDO;
import group2.entity.vo.UserAccountVO;
import group2.entity.vo.UserExperienceVO;
import group2.enums.SexEnum;
import group2.util.AbstractConvertUtil;
import group2.util.RandomUtil;
import org.springframework.util.StringUtils;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 17:27
 * @description: 实体类转换
 **/

public class UserConvertUtil extends AbstractConvertUtil {

    //------------------------VO————>DO------------------------
    public static UserAccountDO voToDo(UserAccountVO userAccountVO) {
        UserAccountDO userAccount = new UserAccountDO();
        userAccount.setAccount(userAccountVO.getAccount())
                .setPassword(userAccountVO.getPassword())
                .setPicture(userAccountVO.getPicture())
                .setName(userAccountVO.getName())
                .setPhone(userAccountVO.getPhone())
                .setWxOpenid(userAccountVO.getWxOpenid())
                .setEmail(userAccountVO.getEmail())
                .setRegisterTime(System.currentTimeMillis());
        String sex = userAccountVO.getSex();
        SexEnum sexEnum =
                "男".equals(sex) ? SexEnum.男 :
                        "女".equals(sex) ? SexEnum.女 : SexEnum.外星人;
        userAccount.setSex(sexEnum);
        return userAccount;
    }

    public static UserExperienceDO voToDo(UserExperienceVO userExperienceVO, Integer lastTimeTotalExperience) {
        UserExperienceDO userExperienceDO = new UserExperienceDO();
        userExperienceDO.setUserId(userExperienceVO.getUserId())
                .setExperience(userExperienceVO.getExperience())
                .setCurrentExperience(userExperienceVO.getExperience() + lastTimeTotalExperience)
                .setDescription(userExperienceVO.getDescription())
                .setTime(System.currentTimeMillis());
        return userExperienceDO;
    }

    //------------------------DO————>DTO------------------------
    public static UserAccountDTO doToDto(UserAccountDO userAccountDO) {
        UserAccountDTO userAccount = new UserAccountDTO();
        userAccount.setId(userAccountDO.getId())
                .setAccount(userAccountDO.getAccount())
                .setPicture(userAccountDO.getPicture())
                .setName(userAccountDO.getName())
                .setSex(StringUtils.isEmpty(userAccountDO.getSex()) ? SexEnum.外星人.toString() : userAccountDO.getSex().toString())
                .setPhone(userAccountDO.getPhone())
                .setEmail(userAccountDO.getEmail())
                .setRegisterTime(userAccountDO.getRegisterTime());

        return userAccount;
    }

    public static UserAccountFriendDTO doToFriendDto(UserAccountDO userAccountDO) {
        UserAccountFriendDTO userAccountFriendDTO = new UserAccountFriendDTO();
        userAccountFriendDTO.setId(userAccountDO.getId())
                .setName(userAccountDO.getName())
                .setPicture(userAccountDO.getPicture())
                .setSex(userAccountDO.getSex().toString());
        return userAccountFriendDTO;
    }

    public static UserDTO doToDto(UserAccountDO userAccountDO, UserInfoDO userInfoDO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userAccountDO.getId())
                .setAccount(userAccountDO.getAccount())
                .setPicture(userAccountDO.getPicture())
                .setName(userAccountDO.getName())
                .setSex(userAccountDO.getSex().toString())
                .setPhone(userAccountDO.getPhone())
                .setEmail(userAccountDO.getEmail())
                .setVisitor(userInfoDO.getVisitor())
                .setFollower(userInfoDO.getFollower())
                .setComment(userInfoDO.getComment())
                .setScore(userInfoDO.getScore())
                .setExperience(userInfoDO.getExperience())
                .setRegisterTime(userAccountDO.getRegisterTime())
                .setLastLoginTime(userInfoDO.getLastLoginTime());
        return userDTO;
    }

    //------------------------other————>DO------------------------
    // 新增用户,只提供账号和密码
    public static UserAccountDO getDo(String account, String password) {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password))
            return null;
        UserAccountDO userAccountDO = new UserAccountDO();
        userAccountDO.setAccount(account)
                .setPicture("")
                .setName("用户" + RandomUtil.randomString(6))
                .setPassword(password)
                .setSex(SexEnum.外星人)
                .setPhone("")
                .setEmail("")
                .setWxOpenid("")
                .setRegisterTime(System.currentTimeMillis());
        return userAccountDO;
    }
}
