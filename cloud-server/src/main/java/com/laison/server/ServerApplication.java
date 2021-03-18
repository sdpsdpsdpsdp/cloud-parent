package com.laison.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Desc
 * @Author sdp
 * @Date 2021/3/5 15:15
 */
@SpringBootApplication
@MapperScan("com.laison.server.mapper")
//@EnableDiscoveryClient
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
