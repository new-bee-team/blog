package group7.email.service;

import org.springframework.mail.MailSendException;

public interface IEmailService {
    Boolean checkCode(String email, String newCode);

    Boolean isUserEmailSingle(String email);

    Boolean isUserAccountSingle(String account);

    Boolean isUserEmailBound(Integer userId);

    Integer sendSimpleMail(String to) throws MailSendException;

}
