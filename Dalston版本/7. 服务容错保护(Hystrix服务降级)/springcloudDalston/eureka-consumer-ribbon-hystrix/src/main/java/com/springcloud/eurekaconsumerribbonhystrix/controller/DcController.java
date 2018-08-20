package com.springcloud.eurekaconsumerribbonhystrix.controller;

import com.springcloud.eurekaconsumerribbonhystrix.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author RLY
 */

@RestController
public class DcController {

    @Autowired
    ConsumerService consumerService;
    @GetMapping("/consumer")
    public String dc() {
        return consumerService.consumer();
    }


}