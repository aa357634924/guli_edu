package com.rj.utils;

/**
 * 返回状态码
 *
 * @Author: rj
 * @Date: 2020-10-28 23:19
 * @Version: 1.0
 */
public interface ReturnCode {
    //成功
    public static final Integer SUCCESS = 20000;
    //失败
    public static final Integer ERROR = 20001;
    //包含子数据
    public static final Integer HASCHILDREN = 20002;

    //已发布
    public static final String PUBLISHED = "Normal";
    //未发布
    public static final String NOTPUBLISH = "Draft";


}
