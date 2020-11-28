package com.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.client.DataClient;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private DataClient dataClient;

    @RequestMapping("feignGet")
    public String feignGet(){
        return dataClient.getData();
    }
    //资源路径
    private final String url = "http://127.0.0.1:8001/provider/get";

    @RequestMapping("get")
    public String get(){
        RestTemplate template = new RestTemplate();
        String data = template.getForObject(url, String.class);
        return data;
    }
}