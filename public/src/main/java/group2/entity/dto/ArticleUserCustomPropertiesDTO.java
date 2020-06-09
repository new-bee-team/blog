package group2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author: KongKongBaby
 * @create: 2020-06-09 19:26
 * @description: 文章的用户自定义属性 比如自定义的标签 分类
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleUserCustomPropertiesDTO implements Serializable {
    // 数据库拿到 A&B&C&D 转换成A B C D
    private List<String> tag;
    // 同标签tag
    private List<String> category;

    // 传入 A&B&C&D 转换成A B C D
    public ArticleUserCustomPropertiesDTO(String tagString, String categoryString) {
        if (!StringUtils.isEmpty(tagString)) {
            String[] arr = tagString.split("&");
            this.tag = Arrays.asList(arr);
        }
        if (!StringUtils.isEmpty(categoryString)) {
            String[] arr = categoryString.split("&");
            this.tag = Arrays.asList(arr);
        }
    }
}
