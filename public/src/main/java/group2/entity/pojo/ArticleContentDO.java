package group2.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 11:40
 * @description: 文章内容（不经常变化）
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleContentDO implements Serializable {
    private Integer id;
    private Integer articleId; // 外键，对应ArticleDO的id
    private String title;//标题
    private String author;//作者
    private String category;//分类
    private String tag; //标签
    private String summary; //摘要
    private String code; //代码块
    private String reference; //引用
    private String body; //正文内容
    private String type; //创作类型
    private Long publish; //发布时间
}
