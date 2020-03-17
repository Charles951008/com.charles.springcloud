package com.charles.springcloud;

import com.charles.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @description ribbon是consumer端进行协调选择服务（即负载均衡）的中间件 可以定为轮询 随机等等不同类型的负载均衡算法
 * @author Charles
 * 负载均衡算法：rest接口第几次请求数 % 服务器集群总数量=实际调用服务器位置下标，每次服务重启动后rest接口计数从1开始
 */
@SpringBootApplication
@EnableEurekaClient
/**
 * @author Charles
 * @RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
 */

public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
