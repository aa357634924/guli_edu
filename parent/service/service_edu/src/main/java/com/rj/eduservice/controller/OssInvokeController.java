package com.rj.eduservice.controller;

import com.rj.eduservice.feign.OssInvokeInterface;
import com.rj.utils.ResponseResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apiguardian.api.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * TODO
 *  测试openfeign远程调用oss系统接口
 * @author rj
 * @version 1.0
 * @date 2020-11-06 13:46
 */
@ApiModel("远程调用oss系统接口")
@RestController
@RequestMapping("/openfeign/oss")
@CrossOrigin
public class OssInvokeController {

    @Autowired
    private OssInvokeInterface ossInvokeInterface;

    @ApiOperation(value="测试接口", notes="测试接口", produces="application/json")
    @GetMapping("/test")
    public ResponseResult test(){
        ResponseResult test = ossInvokeInterface.test();
        return test;
    }
}
