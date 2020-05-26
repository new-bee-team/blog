package group1.util;

import group2.entity.pojo.UserAccountDO;
import group2.entity.vo.UserAccountVO;
import group2.enums.Sex;
import group2.util.RandomUtil;
import org.springframework.util.StringUtils;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 17:27
 * @description: 实体类转换
 **/

public class Convert {
    public static UserAccountDO voToDo(UserAccountVO userAccount){
        UserAccountDO userAccountDO = new UserAccountDO();
        String sex= userAccount.getSex();
        Sex sexDo = Sex.外星人;
        if (null != sex){
            if (sex.equals("男"))
                sexDo = Sex.男;
            if (sex.equals("女"))
                sexDo = Sex.女;
        }
        userAccountDO.setName(userAccount.getName())
                .setPassword(userAccount.getPassword())
                .setSex(sexDo)
                .setPhone(null == userAccount.getPhone() ? "":userAccount.getPhone())
                .setEmail(null == userAccount.getEmail() ? "":userAccount.getEmail())
                .setWxOpenid(null == userAccount.getWxOpenid() ? "":userAccount.getWxOpenid())
                .setRegisterTime(System.currentTimeMillis());
        return userAccountDO;
    }

    public static UserAccountDO getDo(String account,String password){
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password))
            return null;
        UserAccountDO userAccountDO = new UserAccountDO();
        userAccountDO.setName("用户"+RandomUtil.randomString(6))
                .setAccount(account)
                .setPassword(password)
                .setRegisterTime(System.currentTimeMillis());
        return userAccountDO;
    }
}
