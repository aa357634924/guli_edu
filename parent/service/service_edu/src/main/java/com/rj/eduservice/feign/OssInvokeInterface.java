package com.rj.eduservice.feign;

import com.rj.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO
 *  声明调用远程方法接口
 *  远程调用失败后，执行熔断器OssInvokeInterfaceHystrix
 * @Author: rj
 * @Date: 2020-11-06 13:43
 * @Version: 1.0
 */
@FeignClient(name = "aliyun-oss-9001",fallback = OssInvokeInterfaceHystrix.class)
@Component
public interface OssInvokeInterface {
    @GetMapping("/oss/openFeign/test")
    public ResponseResult test();
}
