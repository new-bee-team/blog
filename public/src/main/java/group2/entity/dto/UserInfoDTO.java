package group2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 11:06
 * @description: 用户信息表（经常变化的属性）
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfoDTO implements Serializable {
    private Integer id;
    private Integer userId;  //逻辑外键
    private Integer visitor; //访客数
    private Integer follower; //被关注数
    private Integer comment; //评论数
    private Integer score; //积分
    private Integer experience; //经验
    private Long lastLoginTime;
}
