package group2.entity.pojo;

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
public class UserInfoDO implements Serializable {
    private Integer id;
    private Integer userId;  //逻辑外键
    private Integer follower; //粉丝数
    private Integer visitors; //访客数
    private Integer followed; //被关注数
    private Integer comments; //评论数
    private Integer score; //积分
    private Integer experience; //经验
    private Long lastLoginTime;
}
