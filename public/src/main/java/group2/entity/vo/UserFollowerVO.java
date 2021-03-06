package group2.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: jiacheng.xing
 * @Date: 2020.06.05 10:34
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserFollowerVO implements Serializable {
    private Integer bloggerId; //博主 逻辑外键对应用户id
    private Integer followerId; //粉丝 逻辑外键对应用户id
}
