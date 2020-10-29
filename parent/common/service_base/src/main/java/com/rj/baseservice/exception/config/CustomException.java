package com.rj.baseservice.exception.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *  自定义异常类
 * @author rj
 * @version 1.0
 * @date 2020-10-29 12:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{
    /** 返回状态码 */
    private Integer code;
    /** 返回消息 */
    private String msg;
}
