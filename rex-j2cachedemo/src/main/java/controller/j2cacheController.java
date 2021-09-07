package controller;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    public List<String> getInfo() {
        CacheObject cacheObject =cacheChannel.get(key,region);
        return null;
    }


}
