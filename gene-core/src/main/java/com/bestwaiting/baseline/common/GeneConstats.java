package com.bestwaiting.baseline.common;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by zhaoren01
 * Date 18/4/26
 */
public class GeneConstats {
    static public Map<String, String> dataTypeMap = Maps.newHashMap();

    static {
        dataTypeMap.put("int", "Integer");
        dataTypeMap.put("tinyint", "Integer");
        dataTypeMap.put("smallint", "Integer");
        dataTypeMap.put("mediumint", "Integer");
        dataTypeMap.put("bigint", "Long");
        dataTypeMap.put("varchar", "String");
        dataTypeMap.put("char", "String");
        dataTypeMap.put("text", "String");
        dataTypeMap.put("date", "Date");
        dataTypeMap.put("datetime", "Date");
        dataTypeMap.put("timestamp", "Date");
        dataTypeMap.put("decimal", "BigDecimal");
        dataTypeMap.put("bit", "Boolean");
        dataTypeMap.put("float", "Float");
        dataTypeMap.put("time", "LocalTime");
    }
}
