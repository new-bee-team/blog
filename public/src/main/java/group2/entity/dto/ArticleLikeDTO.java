package group2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: jiacheng.xing
 * @Date: 2020.06.05 10:31
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleLikeDTO implements Serializable {
    private Integer id;
    private Integer userId; //逻辑外键 用户id
    private Integer articleId; //逻辑外键 文章id
    private String title;
    private Long time; //点赞时间
}