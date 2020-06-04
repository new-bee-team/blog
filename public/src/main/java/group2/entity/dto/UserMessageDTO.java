package group2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 15:55
 * @description: 用户留言表
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserMessageDTO implements Serializable {
    private Integer id;
    private Integer userId; //逻辑外键 用户id
    private String userName;
    private Integer bloggerId; //逻辑外键 用户id
    private String bloggerName;
    private String content; //留言内容 长度限制255
    private Long time; //留言时间
}
