package com.bestwaiting.baseline.utils;

import com.google.common.base.Charsets;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

/**
 * VelocityUtils
 *
 * @author bestwaiting
 * @date 2020-03-30 23:36
 */
public class VelocityUtils {

    public static String fileGene(String templateName, Map<String, Object> context) {
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine = new VelocityEngine();
        //初始化参数
        Properties properties = new Properties();
        //设置velocity资源加载方式为class
        properties.setProperty("resource.loader", "class");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        velocityEngine.setProperties(properties);
        VelocityContext velocityContext = new VelocityContext();
        for (String key : context.keySet()) {
            velocityContext.put(key, context.get(key));
        }
        StringWriter writer = new StringWriter();
        velocityEngine.mergeTemplate(templateName, Charsets.UTF_8.name(), velocityContext, writer);
        return writer.toString();
    }

    public static String stringGene(String templateContext, Map<String, Object> context) {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();
        VelocityContext velocityContext = new VelocityContext(context);
        StringWriter stringWriter = new StringWriter();
        velocityEngine.evaluate(velocityContext, stringWriter, "template", templateContext);
        return stringWriter.toString();
    }
}
