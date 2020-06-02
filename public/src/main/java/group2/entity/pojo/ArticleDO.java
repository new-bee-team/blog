package group2.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: KongKongBaby
 * @create: 2020-06-02 11:39
 * @description: 文章（经常变化）
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ArticleDO implements Serializable {
    private Integer id;
    private Integer stars; //收藏数
    private Integer comments; //评论数
    private Integer visitors; //浏览量（一个用户多次浏览不算，不包括自己）
    private Integer likes; //点赞数
    private Boolean open; //false私密  true公开(暂时不考虑好友系统)
    private Boolean top; //是否置顶
    private Long lastUpdateTime; //最后一次更新文章的时间
}
