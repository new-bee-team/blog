package group2.entity.pojo;

import group2.enums.Sex;
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
    private String name;
    private String password;
    private Sex sex;
    private String phone;
    private String email;
    private String wxOpenid;
    private Long registerTime;
}
