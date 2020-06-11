package group2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-11 22:09
 * @description:
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDTO implements Serializable {
    private Integer id;

    private String account;
    private String picture;
    private String name;
    private String sex;
    private String phone;
    private String email;

    private Integer visitor; //访客数
    private Integer follower; //被关注数
    private Integer comment; //评论数
    private Integer score; //积分
    private Integer experience; //经验

    private Long registerTime;
    private Long lastLoginTime;
}
