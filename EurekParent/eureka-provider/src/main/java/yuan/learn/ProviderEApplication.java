package yuan.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/6/21 16:43
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@SpringBootApplication
@EnableDiscoveryClient // 激活DiscoveryClient
@EnableEurekaClient
public class ProviderEApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderEApplication.class,args);
    }
}
