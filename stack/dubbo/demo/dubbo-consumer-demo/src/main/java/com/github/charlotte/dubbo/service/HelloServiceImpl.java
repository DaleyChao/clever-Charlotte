package com.github.charlotte.dubbo.service;


/**
 * @author Daniel
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        String result = "hello " + name;
        System.out.println(result);
        return result;
    }
}
