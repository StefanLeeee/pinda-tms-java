package com.itheima.controller;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang
 * @date 9/7/2021 8:27 PM
 * @description
 */
@RestController
@RequestMapping("/cache")
public class j2cacheController {

    private String key = "myKey";
    private String region = "rx";


    @Autowired
    private CacheChannel cacheChannel;

    @GetMapping("/getCacheData")
    public List<String> getCacheData() {
        CacheObject cacheObject =cacheChannel.get(key,region);
        if (cacheObject.getValue() == null) {
            List<String> data = new ArrayList<>();
            data.add("beijing");
            data.add("nanjing");
            data.add("shanghai");
            //将从数据库中获取的数据载入缓存
            cacheChannel.set("rx", "city", data);
            return data;
        }
        return (List<String>) cacheObject.getValue();

    }


}
