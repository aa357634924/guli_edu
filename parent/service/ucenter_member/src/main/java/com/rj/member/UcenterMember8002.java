package com.rj.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-11-07 13:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.rj.member","com.rj.baseservice"})
public class UcenterMember8002 {
    public static void main(String[] args) {
        SpringApplication.run(UcenterMember8002.class,args);
    }
}
