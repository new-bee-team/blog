package group7.controler;

import group7.service.IEmailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KongKongBaby
 * @create: 2020-05-27 14:44
 * @description:
 **/

@RestController
@RequestMapping("/email")
@Api(tags = "邮件相关")
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/send/{to}")
    public Integer sendMail(@PathVariable String to){
        return emailService.sendSimpleMail(to);
    }
}
