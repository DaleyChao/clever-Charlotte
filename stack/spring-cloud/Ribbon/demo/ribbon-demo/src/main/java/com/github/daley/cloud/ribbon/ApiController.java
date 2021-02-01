package com.github.daley.cloud.ribbon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ApiController {
  final Logger log = LoggerFactory.getLogger(ApiController.class);

  @Autowired
  DiscoveryClient discoveryClient;

//  @Autowired
//  private RestTemplate

//  /**
//   * 手写简单ribbon
//   * @return
//   */
//  @Bean
//  public RestTemplate restTemplate() {
//    return new RestTemplate();
//  }

  private ServiceInstance loadBalance(String serviceName) {
    List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
    ServiceInstance instance = instances.get(new Random().nextInt(instances.size()));
    log.info("负载均衡 选出来的ip："+instance.getHost()+",端口："+instance.getPort());
    return instance;
  }



  @RequestMapping("ribbon")
  public Map apiTest(String param){
    //手写 ribbon调用
    ServiceInstance instance = loadBalance(param);
//    String url = "http" + instance.getHost()+":"+instance.getPort()+uri;
//    ResponseEntity<ResponseResult> resultEntity = restTemplate.postForEntity(url, smsSendRequest, ResponseResult.class);
//    ResponseResult result = resultEntity.getBody();
    Map map = new HashMap();
    map.put("fuck",param);
    return map;
  }
}
