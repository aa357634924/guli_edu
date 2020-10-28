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
    private Integer returnCode;

    @ApiModelProperty(value = "返回消息信息")
    private String returnMessage;

    @ApiModelProperty(value = "返回数据信息")
    private Map<String,Object> returnData = new HashMap<>();

    //构造函数私有化，防止其他类创建此类对象
    private ResponseResult(){}

    /**
     * 成功静态方法
     * */
    public static ResponseResult ok(){
        ResponseResult r = new ResponseResult();
        r.setSuccess(true);
        r.setReturnCode(ReturnCode.SUCCESS);
        r.setReturnMessage("操作成功");
        return r;
    }

    /**
     * 失败静态方法
     * */
    public static ResponseResult error(){
        ResponseResult r = new ResponseResult();
        r.setSuccess(false);
        r.setReturnCode(ReturnCode.ERROR);
        r.setReturnMessage("操作失败");
        return r;
    }

    public ResponseResult success(Boolean bool){
        this.setSuccess(true);
        return this;
    }

    public ResponseResult returnCode(Integer returnCode){
        this.setReturnCode(returnCode);
        return this;
    }

    public ResponseResult returnMessage(String returnMessage){
        this.setReturnMessage(returnMessage);
        return this;
    }

    public ResponseResult returnData(Map<String,Object> returnData){
        this.setReturnData(returnData);
        return this;
    }

    public ResponseResult returnData(String key,Object object){
        this.returnData.put(key,object);
        return this;
    }
}
