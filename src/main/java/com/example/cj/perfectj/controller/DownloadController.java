package com.example.cj.perfectj.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

/**
 * Created on 2020-05-10
 */
@RestController
@RequestMapping(path = "/download")
public class DownloadController {

    @GetMapping("")
    public ResponseEntity download(final HttpServletResponse response) {
        StreamingResponseBody stream = out -> {
            ServletOutputStream outputStream = response.getOutputStream();
            for (int i = 0; i < 100; i++) {
                outputStream.println("handsome" + i);
            }
            outputStream.close();
        };
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"handsome.txt\"")
                .body(stream);
    }

    @GetMapping("/2")
    public void download2(HttpServletResponse response) throws IOException {
        BufferedInputStream buffInputStream = null;
        OutputStream outputStream = null;
        try {
            buffInputStream = new BufferedInputStream(DownloadController.class.getResourceAsStream("DownloadController.class"));
            outputStream = response.getOutputStream();
            byte[] buff = new byte[1024*1024]; //如果是稍微大的文件，这里配置的大一些
            int len;
            while((len = buffInputStream.read(buff)) > 0) {
                //把文件流写入到response的输出流中，供请求端请求
                outputStream.write(buff, 0, len);
                outputStream.flush();
            }
        } finally {
            if(buffInputStream != null) {
                buffInputStream.close();
            }
            if(outputStream != null) {
                outputStream.close();
            }
        }
    }

    @GetMapping("/3")
    public ResponseEntity<Resource> download3() {
        InputStream resourceAsStream = DownloadController.class.getResourceAsStream("DownloadController.class");
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"DownloadController.class\"")
                .body(new InputStreamResource(resourceAsStream));
    }
}
