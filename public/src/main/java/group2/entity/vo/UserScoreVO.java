package group2.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-04 17:50
 * @description:
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserScoreVO implements Serializable {
    private Integer userId; //逻辑外键 用户id
    private Boolean operation; // 0/false——扣除  1/true——增加
    private Integer score; //此次增加或扣除的的积分值
    private String description; // 说明
}
