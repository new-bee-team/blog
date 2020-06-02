package group2.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 14:57
 * @description: 文章点赞记录表
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleLikeDO implements Serializable {
    private Integer id;
    private Integer userId; //逻辑外键 用户id
    private Integer articleId; //逻辑外键 文章id
    private Integer status; //点赞状态 0——取消点赞  1——点赞（页面根据01显示不同的点赞状态）
    private Long time; //点赞时间
}