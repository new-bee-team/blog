package group1.util;

import group2.entity.pojo.UserAccountDO;
import group2.entity.vo.UserAccountVO;
import group2.enums.SexEnum;
import group2.util.RandomUtil;
import org.springframework.util.StringUtils;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 17:27
 * @description: 实体类转换
 **/

public class Convert {

    public static UserAccountVO doToVo(UserAccountDO userAccountDO) {
        UserAccountVO userAccount = new UserAccountVO();
        userAccount.setId(userAccountDO.getId())
                .setAccount(userAccountDO.getAccount())
                .setEmail(userAccountDO.getEmail())
                .setName(userAccountDO.getName())
                .setPicture(userAccountDO.getPicture())
                .setPhone(userAccountDO.getPhone())
                .setSex(StringUtils.isEmpty(userAccountDO.getSexEnum()) ? SexEnum.外星人.toString() : userAccountDO.getSexEnum().toString());
        return userAccount;
    }

    // 新增用户,只提供账号和密码
    public static UserAccountDO getDo(String account, String password) {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password))
            return null;
        UserAccountDO userAccountDO = new UserAccountDO();
        userAccountDO.setName("用户" + RandomUtil.randomString(6))
                .setPicture("")
                .setAccount(account)
                .setPassword(password)
                .setRegisterTime(System.currentTimeMillis())
                .setPhone("")
                .setSexEnum(SexEnum.外星人)
                .setEmail("")
                .setWxOpenid("");
        return userAccountDO;
    }
}
