package com.github.charlotte.arica.controller;

import com.github.charlotte.arica.util.FreemarkerUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author Daniel
 */
@Controller
@RequestMapping("/freemarker")
public class IndexController {


    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;

    @RequestMapping("/freemarkerIndex")
    public String freemarker(Map<String, Object> dataModel) {
        dataModel.put("name", "张三");
        dataModel.put("message", "hello world");

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "苹果");
        map1.put("price", 4.5);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "香蕉");
        map2.put("price", 6.3);
        list.add(map1);
        list.add(map2);
        dataModel.put("goodsList", list);
        dataModel.put("today", new Date());
        dataModel.put("number", 123456789L);
        return "index";
    }

    @RequestMapping("createIndex")
    @ResponseBody
    public void createFileByFreemarker() throws IOException, TemplateException, IOException {

//        //创建配置对象
//        Configuration configuration = new Configuration(Configuration.getVersion());
//        //设置默认生成文件编码
//        configuration.setDefaultEncoding("utf-8");
//        //设置模板路径
//        configuration.setClassForTemplateLoading(this.getClass(), "/templates");
//        //获取模板
        Template template = FreemarkerUtil.getTemplate("index.ftl");
        //加载数据
        Map<String, Object> dataModel  =new HashMap<>();
        dataModel.put("name", "张三");
        dataModel.put("message", "hello world");

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "苹果");
        map1.put("price", 4.5);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "香蕉");
        map2.put("price", 6.3);
        list.add(map1);
        list.add(map2);

        dataModel.put("goodsList", list);
        dataModel.put("today", new Date());
        dataModel.put("number", 123456789L);
        //创建输出对象,将文件输出到 tmp 目录下
        FileWriter fileWriter = new FileWriter("/Users/macuser/code/backend/Clever-Charlotte/project/Arica/tmp/index.html");
        //渲染模板和数据
        template.process(dataModel, fileWriter);
        //关闭输出
        fileWriter.close();
    }
//    FreeMarkerConfigurer

}
