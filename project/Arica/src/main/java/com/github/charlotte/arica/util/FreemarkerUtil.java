package com.github.charlotte.arica.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author Daniel
 * FreeMarker 工具类
 */
@Component
public class FreemarkerUtil {

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private static FreeMarkerConfigurer staticFreeMarkerConfigure;

    private static Configuration configuration;


    @PostConstruct
    public void init() {
        staticFreeMarkerConfigure = freeMarkerConfigurer;
        configuration = staticFreeMarkerConfigure.getConfiguration();
    }

    public static FreeMarkerConfigurer getFreeMarkerConfigurer() {
        return staticFreeMarkerConfigure;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static Template getTemplate(String path) throws IOException {
        return staticFreeMarkerConfigure.getConfiguration().getTemplate(path);
    }

}
