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
    private Integer articleId; // 逻辑外键，对应ArticleDO的id
    private String title;//标题
    private Integer authorId; //逻辑外键，对应UserAccount的id
    private String author;//作者(冗余字段)
    private String category;//分类
    private String tag; //标签
    private String summary; //摘要
    private String code; //代码块
    private String reference; //引用
    private String body; //正文内容
    private Boolean type; //创作类型, true原创  false转载
    private Long publish; //发布时间
}
