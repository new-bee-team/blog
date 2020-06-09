package group2.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-05 10:06
 * @description:
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleContentVO implements Serializable {
    // 首先在article插入数据，根据返回的id 在article-content插入数据
    private Integer authorId;
    private String title;//标题
    private String category;//分类
    private String tag; //标签
    private Integer type; //创作类型, 0原创 1转载 2翻译 3资源
    private String summary; //摘要
    private String contentHTML; //正文内容 HTML格式
    private String contentMD; //正文内容 MD格式
}
