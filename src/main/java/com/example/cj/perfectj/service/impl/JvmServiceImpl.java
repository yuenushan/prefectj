package com.example.cj.perfectj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cj.perfectj.service.JvmService;

/**
 * Created on 2020-06-10
 */
@Service
public class JvmServiceImpl implements JvmService {
    @Override
    public List<Byte[]> heapOom() {
        List<Byte[]> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Byte[] bytes = new Byte[1024 * 1024];
            list.add(bytes);
        }
        return list;
    }
}
