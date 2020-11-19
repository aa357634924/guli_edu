package com.rj.oss.service.impl;

import cn.hutool.setting.dialect.Props;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.rj.oss.service.OssService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-31 23:29
 */
@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFileAvatar(MultipartFile file) {
        Props props = new Props("oss.properties");
        String endPoint = props.getProperty("aliyun.oss.file.endpoint");
        String keyid = props.getProperty("aliyun.oss.file.keyid");
        String keysecret = props.getProperty("aliyun.oss.file.keysecret");
        String bucketname = props.getProperty("aliyun.oss.file.bucketname");
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endPoint, keyid, keysecret);
        // 上传文件流。
        InputStream inputStream = null;
        String url = "";
        try {
            inputStream = file.getInputStream();
            //获取本地文件名称
            String fileName = file.getOriginalFilename();
            //文件名增加UUID防止重复
            fileName = UUID.randomUUID().toString().replace("-","")+fileName;
            // 存放路径按日期进行分类
            String filePath = new DateTime().toString("yyyy/MM/dd");
            filePath += "/"+fileName;
            ossClient.putObject(bucketname, filePath, inputStream);
            // 路径模板 https://edu-rj.oss-cn-beijing.aliyuncs.com/1.jpeg
            url = "https://"+bucketname+"."+endPoint+"/"+filePath;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return url;
    }
}
