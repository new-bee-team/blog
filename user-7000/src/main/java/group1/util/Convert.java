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
    public static UserAccountDO voToDo(UserAccountVO userAccount) {
        UserAccountDO userAccountDO = new UserAccountDO();
        String sex = userAccount.getSex();
        SexEnum sexEnumDo = SexEnum.外星人;
        if (null != sex) {
            if ("男".equals(sex))
                sexEnumDo = SexEnum.男;
            if ("女".equals(sex))
                sexEnumDo = SexEnum.女;
        }
        userAccountDO.setId(userAccount.getId())
                .setName(userAccount.getName())
                .setPassword(userAccount.getPassword())
                .setSexEnum(sexEnumDo)
                .setPhone(StringUtils.isEmpty(userAccount.getPhone()) ? "" : userAccount.getPhone())
                .setEmail(StringUtils.isEmpty(userAccount.getEmail()) ? "" : userAccount.getEmail())
                .setWxOpenid(StringUtils.isEmpty(userAccount.getWxOpenid()) ? "" : userAccount.getWxOpenid())
                .setRegisterTime(System.currentTimeMillis());
        return userAccountDO;
    }

    public static UserAccountDO getDo(String account, String password) {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password))
            return null;
        UserAccountDO userAccountDO = new UserAccountDO();
        userAccountDO.setName("用户" + RandomUtil.randomString(6))
                .setAccount(account)
                .setPassword(password)
                .setRegisterTime(System.currentTimeMillis());
        return userAccountDO;
    }
}
