package com.rj.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-28 17:50
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.rj.eduservice","com.rj.baseservice"})
public class TeacherMain8881 {
    public static void main(String[] args) {
        SpringApplication.run(TeacherMain8881.class,args);
    }
}
