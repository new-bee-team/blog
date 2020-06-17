package group2.entity.pojo;

import group2.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 15:39
 * @description:
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserAccountDO implements Serializable {
    private Integer id;
    private String account; // 最大10位
    private String picture; // 大小限制？？M
    private String name;    // 最大10位
    private String password; //最大18位
    private SexEnum sex;
    private String phone;
    private String email;
    private String wxOpenid;
    private Long registerTime;
}
