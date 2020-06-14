package group1.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient("third-party")
public interface ThirdPartyClient {

    @PostMapping("/email/send/{addr}")
    Integer sendMail(@PathVariable("addr") String addr);

    @PostMapping("/code/string/get/{k}")
    String getStringCode(@PathVariable("k") String k);

    @PostMapping("/code/string/check/{k}/{v}")
    Boolean checkCode(@PathVariable("k") String k, @PathVariable("v") String v);
}
