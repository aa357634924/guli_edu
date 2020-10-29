package com.rj.baseservice.exception.config;

import com.rj.utils.ExceptionUtil;
import com.rj.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-29 11:54
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 全局异常处理
     *
     * @ExceptionHandler 作用是：执行过程中出现 Exception.class 异常时，会执行此方法
     * @ResponseBody 作用是：返回数据
     * */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult error(Exception e){
        log.error(ExceptionUtil.getMessage(e));
        return ResponseResult.error().returnMessage(e.getMessage());
    }

    /**
     * 自定义异常处理
     * */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult error(CustomException e){
        e.printStackTrace();
        return ResponseResult.error().returnMessage(e.getMsg());
    }
}
