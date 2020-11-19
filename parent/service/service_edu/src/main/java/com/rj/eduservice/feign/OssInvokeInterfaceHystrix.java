package com.rj.eduservice.feign;

import com.rj.utils.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * TODO
 *  熔断器
 * @author rj
 * @version 1.0
 * @date 2020-11-06 15:11
 */
@Component
public class OssInvokeInterfaceHystrix implements OssInvokeInterface {

    @Override
    public ResponseResult test() {
        return ResponseResult.error().returnMessage("调用远程接口失败");
    }
}
