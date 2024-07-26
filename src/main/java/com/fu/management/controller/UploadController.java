package com.fu.management.controller;

import com.fu.management.pojo.Result;
import com.fu.management.utils.UploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private UploadUtils uploadUtils;

    @PostMapping("/api/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传");
        String url = uploadUtils.upload(image);
        return Result.success(url);
    }
}
