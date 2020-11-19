package com.rj.statistics;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-11-08 13:05
 */
@SpringBootTest
public class Datemake {

    @Test
    public void makeDate(){
        System.out.println(new Date());
    }
}
