package com.laison.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Desc
 * @Author sdp
 * @Date 2021/3/5 15:15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    //拦截方式最为简单，中间使用///会默认执行
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
//
//    @Bean
//    public RibbonLoadBalancerClient loadBalancerClient() {
//        return new RibbonLoadBalancerClient();
//    }
}
