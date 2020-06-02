package group2.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 13:55
 * @description: 粉丝
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserFollowerDO implements Serializable {
    private Integer id;
    private Integer bloggerId; //博主 逻辑外键对应用户id
    private Integer followerId; //粉丝 逻辑外键对应用户id
    private Long time; // 关注时间
}
