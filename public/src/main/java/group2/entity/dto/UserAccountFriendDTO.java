package group2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: jiacheng.xing
 * @Date: 2020.06.04 18:04
 * @Description:    其他人显示的用户信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserAccountFriendDTO implements Serializable {
    private Integer id;
    private String name;
    private String picture;
    private String sex;
}
