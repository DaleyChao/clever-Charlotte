package com.github.charlotte.dubbo.service;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author Daniel
 */
@Service(interfaceClass = HelloService.class, version = "0.0.1")
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        String result = "hello " + name;
        System.out.println(result);
        return result;
    }
}
