package com.springcloudlx.apigatewaywitheureka;

import com.springcloudlx.apigatewaywitheureka.filter.SuccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author RLY
 */
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayWithEurekaApplication {

    @Bean
    public SuccessFilter successFilter(){
        return new SuccessFilter();
    }


    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayWithEurekaApplication.class, args);
    }
}
