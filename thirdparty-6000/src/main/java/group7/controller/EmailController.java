package group7.controller;

import group7.service.IEmailService;
import group7.service.impl.EmailServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: KongKongBaby
 * @create: 2020-05-27 14:44
 * @description:
 **/

@RestController
@RequestMapping("/email")
@Api(tags = "邮件服务")
@RefreshScope
public class EmailController {

    @Resource
    private IEmailService emailService;

    @Value("${config.info}")
    private String text;

    @PostMapping("/send/{addr}")
    @ApiOperation(value = "发送邮件(验证码)", notes = "发送成功(200)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addr", value = "邮箱地址", required = true, dataType = "String", paramType = "path")
    })
    public Integer sendMail(@PathVariable String addr) {
        return emailService.sendSimpleMail(addr);
    }

    @GetMapping("/test/config/info")
    public String testConfig() {
        return text;
    }
}
