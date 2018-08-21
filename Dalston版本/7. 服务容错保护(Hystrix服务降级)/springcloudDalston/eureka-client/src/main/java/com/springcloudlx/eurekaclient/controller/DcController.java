package com.springcloudlx.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/dc")
    public String dc()  {
        /*throws InterruptedException
        Thread.sleep(5000L);*/
        String services="Services"+discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
