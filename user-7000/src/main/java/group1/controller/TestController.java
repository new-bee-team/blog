package group1.controller;

import group1.feign.ThirdPartyClient;
import group2.annotation.NotNull;
import group2.entity.vo.UserAccountVO;
import group2.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/**
 * @author: KongKongBaby
 * @create: 2020-06-10 17:01
 * @description:
 **/

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ThirdPartyClient thirdPartyClient;

    @NotNull
    @GetMapping("/{key}/{value}")
    public String testRedis(@PathVariable String key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, 200L, TimeUnit.SECONDS);
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);

        UserAccountVO userAccountVO = new UserAccountVO("1", "1", "1", "1", "1", "1", "1", "1");
        redisTemplate.opsForValue().set("userAccountVO", JsonUtil.objectToJson(userAccountVO), 100L, TimeUnit.SECONDS);
        return redisTemplate.opsForValue().get(key) + "\t" + expire;
    }

    @NotNull
    @PostMapping("/email/send/{addr}")
    public Integer testEmail(@PathVariable String addr) {
        return thirdPartyClient.sendMail(addr);
    }

    @NotNull
    @PostMapping("/session/{key}/{value}")
    public Integer testSession(@PathVariable String key, @PathVariable String value, HttpSession session){
        session.setAttribute(key,value);
        return session.getMaxInactiveInterval();
    }
}