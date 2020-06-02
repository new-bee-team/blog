package group2.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 14:15
 * @description: 文章评论表,只有一级和多级两种。
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleCommentDO implements Serializable {
    private Integer id;
    private Integer articleId; //逻辑外键 文章id
    private Integer fromUserId; //逻辑外键
    private Integer toUserId; //逻辑外键 即 from 回复 to 消息 即  from: @to xxxxx
    private String content; //评论内容 最大255
    private Long time; // 评论时间
}
