package com.bestwaiting.baseline.utils;

import com.google.common.collect.Maps;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreemakerUtils {
    public static void main(String[] args) throws IOException {
        try {
            Configuration conf = new Configuration();
            conf.setDirectoryForTemplateLoading(new File("src/main/resource/vm"));
            Template template = conf.getTemplate("test.xml.ftl");
            StringWriter stringWriter = new StringWriter();
            template.process(Maps.newHashMap(), stringWriter);
            stringWriter.toString();
        } catch (TemplateException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String fileGene(String templateName, Map<String, Object> context) {
        Configuration conf = new Configuration();
        try {
            conf.setDirectoryForTemplateLoading(new File("src/main/resources/ftl"));
            Template template = conf.getTemplate(templateName);
            StringWriter stringWriter = new StringWriter();
            template.process(context, stringWriter);
            return stringWriter.toString();
        } catch (Exception ex) {
            System.out.println("freemaker gene error----" + ex.getMessage());
        }
        return null;
    }


    public static String stringGene(String templateContext, Map<String, Object> params) {
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("template", templateContext);
        Configuration conf = new Configuration();
        conf.setTemplateLoader(stringTemplateLoader);
        String result = StringUtils.EMPTY;
        try {
            Template template = conf.getTemplate("template", "utf-8");
            StringWriter stringWriter = new StringWriter();
            template.process(params, stringWriter);
            result = stringWriter.toString();
            stringWriter.flush();
        } catch (Exception ex) {
            System.out.println("freemaker gene error----" + ex.getMessage());
        }
        return result;
    }
}
