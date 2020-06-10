package group3.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KongKongBaby
 * @create: 2020-06-10 08:01
 * @description:
 **/

@RestController
@RequestMapping("/article/comment")
@Api(tags = "文章评论服务")
public class ArticleCommentController {
}
