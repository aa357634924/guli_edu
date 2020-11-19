package com.rj.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *  统一返回结果对象
 *  采用链式调用方法
 *  使用示例：
 *  ResponseResult r = ResponseResult.ok().returnMessage(message).returnData(data)
 * @author rj
 * @version 1.0
 * @date 2020-10-28 23:18
 */
@Data
public class ResponseResult {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回状态码")
    private Integer code;

    @ApiModelProperty(value = "返回消息信息")
    private String message;

    @ApiModelProperty(value = "返回数据信息")
    private Map<String,Object> data = new HashMap<>();

    //构造函数私有化，防止其他类创建此类对象
    private ResponseResult(){}

    /**
     * 成功静态方法
     * */
    public static ResponseResult ok(){
        ResponseResult r = new ResponseResult();
        r.setSuccess(true);
        r.setCode(ReturnCode.SUCCESS);
        r.setMessage("操作成功");
        return r;
    }

    /**
     * 失败静态方法
     * */
    public static ResponseResult error(){
        ResponseResult r = new ResponseResult();
        r.setSuccess(false);
        r.setCode(ReturnCode.ERROR);
        r.setMessage("操作失败");
        return r;
    }

    public ResponseResult success(Boolean bool){
        this.setSuccess(true);
        return this;
    }

    public ResponseResult returnCode(Integer returnCode){
        this.setCode(returnCode);
        return this;
    }

    public ResponseResult returnMessage(String returnMessage){
        this.setMessage(returnMessage);
        return this;
    }

    public ResponseResult returnData(Map<String,Object> returnData){
        this.setData(returnData);
        return this;
    }

    public ResponseResult returnData(String key,Object object){
        this.data.put(key,object);
        return this;
    }
}
