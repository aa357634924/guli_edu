package com.rj.eduservice.controller;

import com.rj.utils.ResponseResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-30 18:52
 */
@ApiModel("登录 前端控制器接口文档")
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @ApiOperation(value="登录接口", notes="登录接口", produces="application/json")
    @PostMapping("/login")
    public ResponseResult login(){

        return ResponseResult.ok().returnData("token","admin");
    }

    @ApiOperation(value="用户信息查询接口", notes="用户信息查询接口", produces="application/json")
    @GetMapping("/info")
    public ResponseResult info(){

        return ResponseResult.ok().returnData("roles","[admin]").returnData("name","admin").returnData("avatar","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604065447233&di=e35e68f50725e5bd289d0c137ecce440&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201408%2F24%2F20140824154253_45Hay.png");
    }
}
