package com.nhq.controller;

import com.nhq.pojo.Result;
import com.nhq.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;


    //本地存储
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age,MultipartFile image){
//        log.info("Uploading ：{},{},{}",username,age,image);
//
//        try {
//            String originalFilename = image.getOriginalFilename();
//            int indexOf = originalFilename.lastIndexOf(".");
//            String extname = originalFilename.substring(indexOf);
//            String newFileName = UUID.randomUUID() +extname;
//
//            log.info("new file name: {}",newFileName);
//
//            image.transferTo(new File("E:\\"+newFileName));
//            return Result.success();
//        } catch (IOException e) {
//            return Result.error(e.getMessage());
//        }
//
//    }

    @PostMapping("/upload")
    public Result upload(MultipartFile image){
        log.info("文件上传，文件名：{}",image.getOriginalFilename());

        try {
            String result = aliOSSUtils.upload(image);
            log.info("文件url:{}",result);
            return Result.success(result);
        } catch (IOException e) {
            return Result.error(e.getMessage());
        }
    }
}
