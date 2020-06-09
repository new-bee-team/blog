package group3.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KongKongBaby
 * @create: 2020-06-10 07:49
 * @description:
 **/

@RestController
@RequestMapping("/article/content")
@Api(tags = "文章内容服务")
public class ArticleContentController {
}
