package yuan.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yuan.learn.pojo.Goods;

import java.util.List;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/6/21 16:47
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@RestController
public class ConController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("con/{id}")
    public Goods getOne(@PathVariable("id") Integer id){
        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-PROVIDER");
        ServiceInstance instance = instances.get(0);
        return restTemplate.getForEntity("http://"+instance.getHost()+":"+instance.getPort()+"/pro/"+id,
                Goods.class).getBody();
    }
}
