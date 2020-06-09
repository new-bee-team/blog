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
    private Integer authorId; // 逻辑外键 冗余字段
    private Integer stars; //收藏数
    private Integer comments; //评论数
    private Integer visitors; //浏览量（一个用户多次浏览不算，不包括自己）
    private Integer likes; //点赞数
    private Integer open; //0私密  1公开  2好友可见
    private Integer comment; //0不允许评论  1所有都可以评论  2好友可评论
    //优先级类似z-index 最大置顶 默认0
    //选择是否置顶 是的话修改当前优先级最大
    //按照priority从大到小排列
    private Integer priority;
    //假如当前最大优先级是 100 那么新的文章需要置顶 那么该文章优先级为101 同时更新currentMaxPriority = 101
    private Integer currentMaxPriority;
    private Integer status; //0——草稿未发布  1————已发布  2——已删除（有定时任务将已删除的数据移动到对应的表中）
    private Long lastUpdateTime; //最后一次更新文章的时间
}
