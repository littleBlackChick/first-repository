package org.common.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.common.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {

    //这个注解表示要引入一个服务，可以加版本号指定需要引用的
    @DubboReference
    private UserService userService;


    public String getOrder(){

        return userService.getUser();
    }


}
