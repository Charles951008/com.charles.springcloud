package com.charles.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Charles
 */

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced

    /**负载均衡2222*/
    public RestTemplate getRestTemplate() {

        return new RestTemplate();

    }
}
