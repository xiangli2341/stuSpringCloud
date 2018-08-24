package com.springcloudlx.eurekaconsumerfeign.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author RLY
 *
 * @Component 把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
 */
@Component
public class DcClientFallback implements DcClient {

    @Override
    public String consumer() {
        return "fallback";
    }
}
