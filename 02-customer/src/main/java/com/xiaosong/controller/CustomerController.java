package com.xiaosong.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/customer")
    public String customer() {
//        // 1.通过eurekaClient获取到SEARCH服务信息，第二个参数表示是否是以https的方式访问
//        InstanceInfo info = eurekaClient.getNextServerFromEureka("SEARCH", false);
//        // 2.获取到访问地址（拿到的是ip加端口）http://localhost:8081
//        String url = info.getHomePageUrl();
//        System.out.println(url);
//        // 3.通过restTemplate访问
//        String result = restTemplate.getForObject(url + "/search", String.class);
//        // 4.返回
//        return result;
        return restTemplate.getForObject("http://SEARCH/search", String.class);
    }
}
