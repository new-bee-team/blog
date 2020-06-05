package group2.entity.dto;

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
public class UserFollowerDTO implements Serializable {
    private Integer id;
    private Integer bloggerId; //博主 逻辑外键对应用户id
    private String bloggerName;
    private Integer followerId; //粉丝 逻辑外键对应用户id
    private Long time; // 关注时间
}
