package com.itheima.test;


import com.alibaba.fastjson.JSON;
import lombok.val;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Map;

/**
 * 测试百度地图提供的地理编码HTTP服务接口
 */
public class BaiduMapTest {
    public static void main(String[] args) throws Exception {
        String ak = "1XrViM2r3sSuREis5uHU1x1dNcESDOoD";//注意，ak类型必须为服务端类型
        String address = "北京市育新花园小区";
        String httpUrl = "http://api.map.baidu.com/geocoding/v3/?address=" + address + "&output=json&ak=" + ak;

        URL url = new URL(httpUrl);
        URLConnection urlConnection = url.openConnection();
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = urlConnection.getInputStream();
        //封装成带有缓存功能的字符串
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String inputLine = null;
        //若数据为空，则一直读
        while ((inputLine = bufferedReader.readLine()) != null) {
//            将每行inputLine数据存入stringbuilder对象
            stringBuilder.append(inputLine);
        }
        bufferedReader.close();
        System.out.println(stringBuilder);

        Map map = JSON.parseObject(stringBuilder.toString());

        String status = map.get("status").toString();
        //获取成功
        if (status.equals("0")) {
            Map result = (Map) map.get("result");
            Map location = (Map) result.get("location");
            String lngStr = location.get("lng").toString();
            String latStr = location.get("lat").toString();
            DecimalFormat df = new DecimalFormat("#.######");
            String lng = df.format(Double.parseDouble(lngStr));
            String lat = df.format(Double.parseDouble(latStr));

            String r = lng + "," + lat;
            System.out.println(r);
        }
    }
}

