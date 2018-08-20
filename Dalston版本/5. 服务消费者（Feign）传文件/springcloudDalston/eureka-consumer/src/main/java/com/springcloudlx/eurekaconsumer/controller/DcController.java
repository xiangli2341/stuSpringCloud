package com.springcloudlx.eurekaconsumer.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author RLY
 */
@RestController
public class DcController {


    /**
     * 22222注入 LoadBalancerClient 和 RestTemplate，并在 /consumer
     * 接口的实现中，先通过 LoadanlaBnceClient 的choose函数来
     * 负载均衡的选出一个 eureka-client 的服务实例，服务实例存储在
     * ServiceInstance 中，然后通过这些对象中的信息拼接出/dc接口的
     * 详细地址，最后利用 RestTemplate 对象实现对服务提供者接口的调用
     *
     * LoadBalancerClient 是一个负载均衡客户端的抽象定义
     *  RestTemplate 获取服务器中的数据
     */
   /* @Autowired
    LoadBalancerClient loadBalancerClient;*/
    @Autowired
    RestTemplate restTemplate;




    /*33333修改Controller。去掉原来通过LoadBalancerClient选取实例和拼接URL的步骤，
    直接通过RestTemplate发起请求。*/
    @GetMapping("/consumer")
    public String dc() {

//        ServiceInstance serviceInstance=loadBalancerClient.choose("eureka-client");
//        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/dc";
//        System.out.println(url);


        /**
         * 采用了服务名的方式组成。那么这样的请求为什么可以调用成功呢？
         * 因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，
         * 自动的去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，
         * 从而完成服务接口的调用。
         */
        return restTemplate.getForObject("http://eureka-client/dc",String.class);
    }
}
