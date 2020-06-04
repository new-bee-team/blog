package group2.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: jiacheng.xing
 * @Date: 2020.06.04 18:46
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserMessageVO implements Serializable {
    private Integer userId; //逻辑外键 用户id
    private Integer bloggerId; //逻辑外键 用户id
    private String content; //留言内容 长度限制255
}
