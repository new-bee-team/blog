package group2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author: KongKongBaby
 * @create: 2020-06-10 17:00
 * @description: 启用redis代码spring默认session
 **/

@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
