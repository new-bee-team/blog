package group2.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: KongKongBaby
 * @create: 2020-06-14 18:41
 * @description:
 **/

public class CodeUtil {

    @Resource
    static private RedisTemplate redisTemplate;

    public static String setCode(Long time, TimeUnit timeUnit) {
        boolean isTimeNull = StringUtils.isEmpty(time);
        boolean isTimeUnitNull = StringUtils.isEmpty(timeUnit);
        if (isTimeNull && isTimeUnitNull) {
            return setCode();
        }
        if (!(isTimeNull && isTimeUnitNull) && (isTimeNull || isTimeUnitNull)) {
            return null;
        } else {
            String k = RandomUtil.randomString(8);
            String v = RandomUtil.randomString(4);
            redisTemplate.opsForValue().set(k, v, time, timeUnit);
            return k;
        }
    }

    public static String setCode() {
        String k = RandomUtil.randomString(8);
        String v = RandomUtil.randomString(4);
        redisTemplate.opsForValue().set(k, v, 30L, TimeUnit.MINUTES);
        return k;
    }
}
