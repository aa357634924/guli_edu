package com.rj.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * TODO
 *  统计访问量
 * @author rj
 * @version 1.0
 * @date 2020-11-07 22:49
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan( basePackages = {"com.rj.statistics","com.rj.baseservice"} )
public class StatisticsMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(StatisticsMain8003.class,args);
    }
}
