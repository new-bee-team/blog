package group2.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 14:01
 * @description: 文章收藏
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleStarDO implements Serializable {
    private Integer id;
    private Integer userId; //逻辑外键 用户id
    private Integer articleId; //逻辑外键 文章id
    private Long starTime; //收藏时间
}
