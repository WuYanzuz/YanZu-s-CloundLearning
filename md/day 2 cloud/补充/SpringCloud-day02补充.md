## 4.7 consumer通过网关调用provider

![router](D:/itcast/SpringCloud-双元/SpringCloud/day02/讲义/img/router.png)

### 4.7.1工程结构

工程搭建参考代码目录`SpringCloud\day02\代码\3. Gateway\2. gateway最终代码`

* api-gateway-server  80端口
* eureka-server-gateway  8761端口
* gateway-consumer 9000端口
* gateway-provider 8001端口

### 4.7.2 配置consumer通过gateway调用provider

> 修改feign接口上FeignClient注解的value值为api-gateway-server的应用名称

```java
package com.itheima.consumer.feign;


import com.itheima.consumer.domain.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(value = "api-gateway-server",fallback = GoodsFeignClientFallback.class)
public interface GoodsFeignClient {


    @GetMapping("/goods/findOne/{id}")
    public Goods findGoodsById(@PathVariable("id") int id);

}

```

### 4.7.3 调用方式

* 访问eureka
  * http://localhost:8761/
* 访问消费者
  * 使用非网关的方式 http://localhost:9000/order/goods/2
  * 使用网关不配置微服务名称的方式 http://localhost/order/goods/2
  * 使用网关配置微服务名称的方式 http://localhost/gateway-consumer/order/goods/2
* 访问生产者
  * 使用非网关的方式 http://localhost:8001/goods/findOne/2
  * 使用网关不配置微服务名的方式 http://localhost/goods/findOne/2
  * 使用网关配置微服务名称的方式 http://localhost/gateway-provider/goods/findOne/2

