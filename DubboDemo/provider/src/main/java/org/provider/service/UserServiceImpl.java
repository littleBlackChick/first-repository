package org.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.common.UserService;

@DubboService //定义的服务
public class UserServiceImpl implements UserService {

    public String getUser(){
        return "hello";
    }

}
