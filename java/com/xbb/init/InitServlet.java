package com.xbb.init;

import com.xbb.constant.PathConstant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component
public class InitServlet implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        // 项目路径
        PathConstant.WEB_FILE_ROOT = ClassUtils.getDefaultClassLoader()
                .getResource("").getPath().substring(1);
        // 图片存储目录
        PathConstant.IMG_STORAGE_ROOT = PathConstant.WEB_FILE_ROOT + "static/images/";
        // 文件存储目录
        PathConstant.FILE_STORAGE_ROOT = PathConstant.WEB_FILE_ROOT + "static/file/";
    }

}
