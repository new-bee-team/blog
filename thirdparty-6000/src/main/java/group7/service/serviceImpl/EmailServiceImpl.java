package group7.service.serviceImpl;

import group7.service.IEmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: KongKongBaby
 * @create: 2020-05-27 14:45
 * @description:
 **/
@Service
public class EmailServiceImpl implements IEmailService {

    @Resource
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;

    @Override
    public Boolean checkCode(String email, String newCode) {
        return null;
    }

    @Override
    public Boolean isUserEmailSingle(String email) {
        return null;
    }

    @Override
    public Boolean isUserAccountSingle(String account) {
        return null;
    }

    @Override
    public Boolean isUserEmailBound(Integer userId) {
        return null;
    }

    @Override
    public Integer sendSimpleMail(String to) throws MailSendException {
        System.out.println("发送邮件...");
        String subject = "验证码";
        String code = UUID.randomUUID().toString().substring(0, 4);
        String content = "你好，您的验证码是:\t" + code;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
        } catch (MailSendException mailSendException) {
            throw mailSendException;
        } catch (Exception e) {
            throw e;
        }
        return 200;
    }
}
