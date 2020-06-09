package group3.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KongKongBaby
 * @create: 2020-06-10 07:47
 * @description:
 **/

@RestController
@RequestMapping("/article/info")
@Api(tags = "文章信息服务")
public class ArticleController {
}
