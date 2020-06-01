package group1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserStarter_7000 {

    public static void main(String[] args) {
        SpringApplication.run(UserStarter_7000.class, args);
    }

}
