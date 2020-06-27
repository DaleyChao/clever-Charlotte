package com.github.charlotte.dubbo.controller;

import com.github.charlotte.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Daniel
 */
@RequestMapping("/index")
@Controller
public class DubboController {

    @Reference(version = "0.0.1")
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public Object hello(){

        return helloService.hello(System.currentTimeMillis()+"");
    }

}
