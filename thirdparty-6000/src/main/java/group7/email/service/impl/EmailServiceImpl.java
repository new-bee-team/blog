package group7.email.service.impl;

import group7.email.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: KongKongBaby
 * @create: 2020-05-27 14:45
 * @description:
 **/
@Service
@Slf4j
public class EmailServiceImpl implements IEmailService {

    @Resource
    private JavaMailSender mailSender;
    @Resource
    private RedisTemplate redisTemplate;
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

    /**
     * @author: jiacheng.xing
     * @Date: 2020.05.29 22:02
     * @Description:    发送验证码并保存在redis 30分钟
     */
    @Override
    @Async
    public Integer sendSimpleMail(String to) throws MailSendException {
        log.info("发送邮件...");
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
        //将code保存在redis30分钟
        redisTemplate.opsForValue().set(to,code,30L, TimeUnit.MINUTES);
        return 200;
    }
}
