package group2.entity.pojo;

import group2.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: KongKongBaby
 * @create: 2020-06-10 21:36
 * @description:
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserRoleDO {
    private Integer id;
    private Integer userId;
    private RoleEnum role;
}
