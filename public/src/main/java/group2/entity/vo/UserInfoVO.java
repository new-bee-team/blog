package group2.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: jiacheng.xing
 * @Date: 2020.06.05 10:35
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfoVO implements Serializable {
    private Integer userId;  //逻辑外键
    private Integer visitor; //访客数
    private Integer follower; //被关注数
    private Integer comment; //评论数
    private Integer score; //积分
    private Integer experience; //经验
}
