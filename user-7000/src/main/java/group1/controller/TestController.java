package group1.controller;

import group1.dao.UserRoleDao;
import group1.feign.ThirdPartyClient;
//import group1.security.MyUserDetailService;
import group2.annotation.Log;
import group2.annotation.NotNull;
import group2.entity.pojo.UserRoleDO;
import group2.entity.vo.UserAccountVO;
import group2.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource
    private UserRoleDao userRoleDao;

//    @Resource
//    private MyUserDetailService userDetailService;

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

    @Log
    @GetMapping("/hello")
    public String hello(){
        return "hello!";
    }

    @GetMapping("/role/id/{id}")
    public UserRoleDO role(@PathVariable Integer id){
        return userRoleDao.getUserRole(id);
    }

//    @GetMapping("/role/account/{account}")
//    //{"password":"cc9fad4350e3673c965cfe06d668d368","username":"PigPigBoy","authorities":[{"authority":"ROLE_USER"}],"accountNonExpired":true,"accountNonLocked":true,"credentialsNonExpired":true,"enabled":true}
//    public Object role2(@PathVariable String account){
//        UserDetails userDetails = userDetailService.loadUserByUsername(account);
//        return userDetails;
//    }
}