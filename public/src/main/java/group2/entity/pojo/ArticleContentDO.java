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
    private String category;//分类 3级以上可自定义 否则只能使用预设
    private String tag; //标签 3级以上可自定义 否则只能使用预设
    private String summary; //摘要
    private Integer type; //创作类型, 0原创 1转载 2翻译 3资源
    private String contentHTML; //正文内容 HTML格式
    private String contentMD; //正文内容 MD格式
    private Long publish; //发布时间
}
