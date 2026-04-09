package com.xbb.controller;

import com.xbb.common.RespResult;
import com.xbb.constant.PathConstant;
import com.xbb.util.FileUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class FileUploadController {

    /**
     * 图片上传
     */
    @RequestMapping(value = "/uploadImgFile", produces = "application/json;charset=UTF-8")
    public RespResult uploadImgFile(@RequestParam("file") MultipartFile multipartFile) {
        RespResult respResult = new RespResult();
        if (multipartFile != null) {
            String suffix = FileUtils.fileSuffix(multipartFile.getOriginalFilename()); // 文件名后缀
            String tmpFileName = FileUtils.createTmpFileName(suffix); // 生成保证不重复的临时文件名
            File tmpFile = new File(PathConstant.IMG_STORAGE_ROOT, tmpFileName);
            try {
                multipartFile.transferTo(tmpFile); // 写入项目存储位置
                respResult.success("/images/" + tmpFileName);
            } catch (IOException e) {
                respResult.error("上传失败：" + e.getMessage());
                e.printStackTrace();
            }
        }
        return respResult;
    }

    /**
     * 文件上传
     */
    @RequestMapping(value = "/uploadFile", produces = "application/json;charset=UTF-8")
    public RespResult uploadPdfFile(@RequestParam("file") MultipartFile multipartFile) {
        RespResult respResult = new RespResult();
        if (multipartFile != null) {
            String suffix = FileUtils.fileSuffix(multipartFile.getOriginalFilename()); // 文件名后缀
            String tmpFileName = FileUtils.createTmpFileName(suffix); // 生成保证不重复的临时文件名
            File tmpFile = new File(PathConstant.FILE_STORAGE_ROOT, tmpFileName);
            try {
                multipartFile.transferTo(tmpFile); // 写入项目存储位置
                respResult.success(tmpFile.getPath());
            } catch (IOException e) {
                respResult.error("上传失败：" + e.getMessage());
                e.printStackTrace();
            }
        }
        return respResult;
    }

    /**
     * 视频上传
     */
    @RequestMapping(value = "/uploadVideo", produces = "application/json;charset=UTF-8")
    public RespResult uploadVideo(@RequestParam("file") MultipartFile multipartFile) {
        RespResult respResult = new RespResult();
        if (multipartFile != null) {
            String suffix = FileUtils.fileSuffix(multipartFile.getOriginalFilename()); // 文件名后缀
            String tmpFileName = FileUtils.createTmpFileName(suffix); // 生成保证不重复的临时文件名
            File tmpFile = new File(PathConstant.FILE_STORAGE_ROOT, tmpFileName);
            try {
                multipartFile.transferTo(tmpFile); // 写入项目存储位置
                respResult.success("/file/" + tmpFileName);
            } catch (IOException e) {
                respResult.error("上传失败：" + e.getMessage());
                e.printStackTrace();
            }
        }
        return respResult;
    }

}
