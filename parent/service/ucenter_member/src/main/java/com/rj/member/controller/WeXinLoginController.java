package com.rj.member.controller;

import com.rj.member.property.ApplicationProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-11-07 17:13
 */
@Controller
@RequestMapping("/weixin")
@Slf4j
@Api("微信扫码登录 验证接口文档")
@CrossOrigin
public class WeXinLoginController {

    /**
     * s% 代表占位符
     *
     * */
    @ApiOperation(value="跳转到微信扫码登录界面", notes="跳转到微信扫码登录界面", produces="application/json")
    @GetMapping("/toCodePage")
    public String toCodePage(){
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

        //对redirect_url进行URLEncoder编码
        String redirectUrl = ApplicationProperty.WX_OPEN_REDIRECT_URL;
        try {
            redirectUrl = URLEncoder.encode(redirectUrl, "utf-8");
        }catch(Exception e) {
        }
        //设置%s里面值
        String url = String.format(
                baseUrl,
                ApplicationProperty.WX_OPEN_APP_ID,
                redirectUrl,
                "atguigu"
        );
        return "redirect:"+url;
    }
}
