package group1.util;

import group2.entity.dto.UserAccountDTO;
import group2.entity.pojo.UserAccountDO;
import group2.entity.vo.UserAccountVO;
import group2.enums.SexEnum;
import group2.util.AbstractConvert;
import group2.util.RandomUtil;
import org.springframework.util.StringUtils;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 17:27
 * @description: 实体类转换
 **/

public class UserConvert extends AbstractConvert {

    //------------------------VO————>DO------------------------
    //------------------------DO————>DTO------------------------
    public static UserAccountDTO doToDto(UserAccountDO userAccountDO) {
        UserAccountDTO userAccount = new UserAccountDTO();
        userAccount.setId(userAccountDO.getId())
                .setAccount(userAccountDO.getAccount())
                .setPicture(userAccountDO.getPicture())
                .setName(userAccountDO.getName())
                .setSex(StringUtils.isEmpty(userAccountDO.getSexEnum()) ? SexEnum.外星人.toString() : userAccountDO.getSexEnum().toString())
                .setPhone(userAccountDO.getPhone())
                .setEmail(userAccountDO.getEmail())
                .setRegisterTime(userAccountDO.getRegisterTime());

        return userAccount;
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
                .setSexEnum(SexEnum.外星人)
                .setPhone("")
                .setEmail("")
                .setWxOpenid("")
                .setRegisterTime(System.currentTimeMillis());
        return userAccountDO;
    }



}
