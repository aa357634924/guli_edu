package com.rj.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-28 17:50
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
@ComponentScan(basePackages = {"com.rj.eduservice","com.rj.baseservice"})
public class TeacherMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(TeacherMain8001.class,args);
    }
}
