package com.rj.statistics.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

/**
 * @Author: rj
 * @Date: 2020-11-07 23:18
 * @Version: 1.0
 */
@FeignClient("edu-member-8002")
@Component
public interface MemberInvokeService {
    @PostMapping("/member/member/getRegisterNum")
    public Integer getRegisterNum(@RequestBody String date);
}
