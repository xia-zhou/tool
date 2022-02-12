package com.cydeer.spring.endpoint;

import com.cydeer.common.Result;
import com.cydeer.common.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author song.z
 * @date 2022/2/12 4:02 下午
 */
@RestController
@Slf4j
public class FileUploadController {


    @PostMapping(path = "/spring/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) {
        LogUtils.info(log, "file:{}", file.getContentType());
        return new Result<>(file.getOriginalFilename());
    }

    /**
     * 可以不带consumes配置
     *
     * @param file
     * @return
     */
    @PostMapping(path = "/spring/upload/consume", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> uploadWithConsume(@RequestParam("file") MultipartFile file) {
        LogUtils.info(log, "file:{}", file.getContentType());
        return new Result<>(file.getOriginalFilename());
    }

}
