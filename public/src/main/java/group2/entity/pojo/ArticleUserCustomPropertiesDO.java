package group2.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-09 19:26
 * @description: 文章的用户自定义属性 比如自定义的标签 分类
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleUserCustomPropertiesDO implements Serializable {
    private Integer id;
    private Integer userId; // 逻辑外键
    // 用户自定义标签 比如 用户自定义了以下标签：A B C D  存储格式: A&B&C&D
    // 标签只能是数字+字母+中文+下划线+$的组合
    private String tag;
    // 同标签tag
    private String category;
}
