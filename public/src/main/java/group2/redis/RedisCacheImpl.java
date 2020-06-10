package group2.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
@Service
public class RedisCacheImpl implements Cache {
 @Resource
 RedisTemplate redisTemplate ;
    @Override
    public void put(Object key, Object value, int time) {
        redisTemplate.opsForValue().set(key,value,time, TimeUnit.SECONDS);
    }

    @Override
    public Object get(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 删出key
    @Override
    public void remove(Object key) {
        redisTemplate.delete(key);
    }
}
