package com.springcloudlx.eurekaconsumerribbonhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author RLY
 *
 *  1. @EnableCircuitBreaker 注解开启对断路器的使用
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerRibbonHystrixApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaConsumerRibbonHystrixApplication.class).web(true).run(args);
    }
}
