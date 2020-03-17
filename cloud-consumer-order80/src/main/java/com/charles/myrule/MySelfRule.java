package com.charles.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Charles
 */
@Configuration
public class MySelfRule {
    @Bean
    @LoadBalanced

    /**随机分发服务*/
    public IRule getRestTemplate() {

        return new RandomRule();

    }
}
