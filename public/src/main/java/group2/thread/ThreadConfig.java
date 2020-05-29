package group2.thread;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * @author: KongKongBaby
 * @Date: 2020.03.06 23:46
 * @Description:  适合开发时候很少访问量
 */
@Configuration
@EnableAsync
public class ThreadConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        int n = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor newCachedPoolExecutor = new ThreadPoolExecutor(
                1,
                n + 1,
                30L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>( n << 2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        return newCachedPoolExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
