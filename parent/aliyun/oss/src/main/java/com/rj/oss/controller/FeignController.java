package com.rj.oss.controller;

import com.rj.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-11-06 13:38
 */
@RestController
@RequestMapping("/openFeign")
public class FeignController {

    @GetMapping("/test")
    public ResponseResult test(){
        return ResponseResult.ok();
    }
}
