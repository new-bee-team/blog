package group2.entity.dto;

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
public class ArticleDTO implements Serializable {
    private Integer id;
    private String title;
    private String author;
    private String category;
    private String tag;
    private String summary;
    private String type;
    private Integer stars; //收藏数
    private Integer comments; //评论数
    private Integer visitors; //浏览量（一个用户多次浏览不算，不包括自己）
    private Integer likes; //点赞数
    private Integer status; //0——草稿未发布  1————已发布  2——已删除（有定时任务将已删除的数据移动到对应的表中）
    private Long lastUpdateTime; //最后一次更新文章的时间
}