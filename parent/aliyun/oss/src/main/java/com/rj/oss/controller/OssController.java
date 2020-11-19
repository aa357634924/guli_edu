package com.rj.oss.controller;

import com.rj.oss.service.OssService;
import com.rj.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-31 23:29
 */
@Api("OssController 前端控制器接口文档")
@RestController
@RequestMapping("/oss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;

    /**
     * 上传头像
     * */
    @ApiOperation(value="上传头像", notes="上传头像", produces="application/json")
    @PostMapping("/upload")
    public ResponseResult uploadOssFile (MultipartFile file){
        String url = ossService.uploadFileAvatar(file);
        return ResponseResult.ok().returnData("url",url);
    }
}
