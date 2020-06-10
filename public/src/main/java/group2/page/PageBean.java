package group2.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: KongKongBaby
 * @create: 2020-06-10 14:21
 * @description: 分页
 **/

@Data
public class PageBean<T> implements Serializable {
    private Integer currentPage; // 当前页（从1开始）
    private Integer pageSize; // 每页多少个
    private Integer totalPages; // 总页数
    private List<T> data;
}
