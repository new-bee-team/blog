package group2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-04 18:42
 * @description:
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserScoreDTO implements Serializable {
    private Integer id;
    private Integer userId; //逻辑外键 用户id
    private String userName;
    private String operation; // 0/false——扣除  1/true——增加
    private Integer score; //此次增加或扣除的的积分值
    private Integer currentScore; //当前的总积分值
    private String description; // 说明
    private Long time;
}
