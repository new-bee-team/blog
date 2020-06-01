package group1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("third-party")
public interface ThirdPartyClient {

    @PostMapping("/email/send/{addr}")
    Integer sendMail(@PathVariable("addr") String addr);
}
