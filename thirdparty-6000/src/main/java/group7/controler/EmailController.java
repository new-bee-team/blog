package group7.controler;

import group7.email.service.IEmailService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: KongKongBaby
 * @create: 2020-05-27 14:44
 * @description:
 **/

@RestController
@RequestMapping("/email")
@Api(tags = "邮件服务")
public class EmailController {

    @Resource
    private IEmailService emailService;

    @PostMapping("/send/{addr}")
    @ApiOperation(value = "发送邮件", notes = "发送成功(200)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addr", value = "邮箱地址", required = true, dataType = "String", paramType = "query")
    })
    public Integer sendMail(@PathVariable String addr) {
        return emailService.sendSimpleMail(addr);
    }
}
