package group1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 扫描范围额外添加group2所在的包（idea报错但可以运行）
@SpringBootApplication(scanBasePackages = {"group1,group2"})
@EnableFeignClients
public class UserStarter_7000 {

    public static void main(String[] args) {
        SpringApplication.run(UserStarter_7000.class, args);
    }

}
