package group7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//不加载 DataSourceAutoConfiguration 这样一个类 否则不配置数据源启动报错
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class ThirdPartyStarter_6000 {

    public static void main(String[] args) {
        SpringApplication.run(ThirdPartyStarter_6000.class, args);
    }

}
