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
    private Integer visitor; //访客数
    private Integer follower; //被关注数
    private Integer comment; //评论数
    private Integer score; //积分
    // Lv 1 (0,10)
    // Lv 2 (10,30)
    // Lv 3 (30,70) ————> 可自定义分类、标签
    // Lv 4 (70,150)
    // Lv 5 (150,310)
    // Lv 6 (310,630)
    // Lv 7 (630,1270)
    // Lv 8 (1270,2550)
    // Lv 9 (2550,5110)
    // Lv 10 (5110,无穷大)
    private Integer experience; //经验
    private Long lastLoginTime;
}
