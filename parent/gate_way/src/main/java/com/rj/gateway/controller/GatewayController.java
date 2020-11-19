package com.rj.gateway.controller;

import com.rj.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-11-09 17:05
 */
@RestController
@RequestMapping("/gateway")
public class GatewayController {
    @GetMapping("/test")
    public ResponseResult test(){
        return ResponseResult.ok();
    }
}
