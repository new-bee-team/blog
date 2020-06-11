package group1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"group1,group2"}) //exclude = {SecurityAutoConfiguration.class},
@EnableFeignClients
public class UserStarter_7000 {

    public static void main(String[] args) {
        SpringApplication.run(UserStarter_7000.class, args);
    }

}
