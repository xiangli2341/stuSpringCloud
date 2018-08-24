package com.springcloudlx.eurekaconsumerribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author RLY
 */


@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerRibbonApplication {


    @Bean
    @LoadBalanced
    public RestTemplate RestTemplate(){
       return new  RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerRibbonApplication.class, args);
    }
}
