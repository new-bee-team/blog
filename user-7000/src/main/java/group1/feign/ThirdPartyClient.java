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

    @PostMapping("/get")
    void getCode(HttpServletRequest request, HttpServletResponse response);

    @PostMapping("eck/{code}")
    Boolean checkCode(@PathVariable String code, HttpServletRequest request);
}
