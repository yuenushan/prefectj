package com.example.cj.perfectj.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

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
}
