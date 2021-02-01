package com.github.daley.cloud.eureka;

import com.fasterxml.jackson.databind.util.JSONPObject;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

  @RequestMapping("test")
  public Map apiTest(String param){
    Map map = new HashMap();
    map.put("fuck",param);
    return map;
  }
}
