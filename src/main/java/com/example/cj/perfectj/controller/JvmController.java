package com.example.cj.perfectj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cj.perfectj.service.JvmService;
import com.example.cj.perfectj.tool.Response;
import com.example.cj.perfectj.tool.ResponseUtil;

/**
 * Created on 2020-06-10
 */
@RestController
@RequestMapping(("/jvm"))
public class JvmController {

    @Autowired
    private JvmService jvmService;

    @GetMapping("/heap/oom")
    public Response<List<Byte[]>> triggerHeapOom() {
        return ResponseUtil.buildSuccess(jvmService.heapOom());
    }
}
