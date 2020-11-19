package com.rj.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @author rj
 * @version 1.0
 * @date 2020-10-31 23:28
 */
public interface OssService {
   public String uploadFileAvatar(MultipartFile file);
}
