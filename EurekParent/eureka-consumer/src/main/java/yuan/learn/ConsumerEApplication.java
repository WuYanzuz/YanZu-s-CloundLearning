package yuan.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/6/21 15:51
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@SpringBootApplication
@EnableDiscoveryClient // 激活DiscoveryClient
@EnableEurekaClient
public class ConsumerEApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerEApplication.class,args);
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
