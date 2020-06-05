package group2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: jiacheng.xing
 * @Date: 2020.06.05 10:33
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleStarDTO implements Serializable {
    private Integer id;
    private Integer userId; //逻辑外键 用户id
    private Integer articleId; //逻辑外键 文章id
    private String title;
    private Long starTime; //收藏时间
}
