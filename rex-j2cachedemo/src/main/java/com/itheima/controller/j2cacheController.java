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
        CacheObject cacheObject =cacheChannel.get(region,key);
        if (cacheObject.getValue() == null) {
            List<String> data = new ArrayList<>();
            data.add("beijing");
            data.add("nanjing");
            data.add("shanghai");
            //将从数据库中获取的数据载入缓存
            cacheChannel.set(region,key, data);
            return data;
        }
        return (List<String>) cacheObject.getValue();
    }

    /**
     * 清理指定缓存
     * @return
     */
    @GetMapping("/evict")
    public String evict() {
        cacheChannel.evict(region, key);
        return "evict success";
    }

    /**
     * 清理指定区域中的 缓存数据
     * 同时清理L1和L2两级缓存
     *
     * @return
     */
    @GetMapping("/clear")
    public String clear() {
        cacheChannel.clear(region);
        return "clear success";
    }

    /**
     * 判断缓存数据是否存在哪一级
     * @return
     */
    @GetMapping("/exists")
    public Boolean exists() {
        boolean exists = cacheChannel.exists(region, key);
        return exists;
    }

    @GetMapping("/check")
    public int check() {
        int check = cacheChannel.check(region, key);
        return check;
    }
}
