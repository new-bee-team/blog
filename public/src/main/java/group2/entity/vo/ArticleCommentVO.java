package group2.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-05 10:04
 * @description:
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleCommentVO implements Serializable {
    private Integer articleId; //逻辑外键 文章id
    private Integer fromUserId; //逻辑外键
    private Integer toUserId; //逻辑外键 即 from 回复 to 消息 即  from: @to xxxxx
    private String content; //评论内容 最大255
}
