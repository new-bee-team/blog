package group1.controller;

import group1.service.impl.UserAccountServiceImpl;
import group2.entity.vo.UserAccountVO;
import group2.returnJson.Result;
import group2.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author: KongKongBaby
 * @create: 2020-05-25 15:28
 * @description:
 **/

@RestController
@RequestMapping("/user")
public class UserAccountController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserAccountServiceImpl userAccountService;

    @GetMapping("/id/{id}")
    public Result getUserAccountById(@PathVariable Integer id) {
        return userAccountService.getUserAccountById(id);
    }

    @PostMapping("/account/{account}/{password}")
    public Result saveUserAccount(@PathVariable String account, @PathVariable String password) {
        return userAccountService.saveUserAccount(account, password);
    }

    @GetMapping("/test/{key}/{value}")
    public String testRedis(@PathVariable String key,@PathVariable String value) {
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key,200L,TimeUnit.SECONDS);
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);

        UserAccountVO userAccountVO = new UserAccountVO(1,"1","1","1","1","1","1");
        redisTemplate.opsForValue().set("userAccountVO", JsonUtil.objectToJson(userAccountVO),100L,TimeUnit.SECONDS);
        return redisTemplate.opsForValue().get(key)+"\t"+expire;
    }

    @PostMapping("/test/email/send/{addr}")
    public Integer testEmail(@PathVariable String addr){
        return (Integer) userAccountService.test1(addr);
    }
}
