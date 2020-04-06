package com.bestwaiting.baseline.enums;

import lombok.Getter;

/**
 * ResourceEnum
 *
 * @author bestwaiting
 * @date 2020-04-06 22:12
 */
@Getter
public enum ResourceEnum {
    JAVA(0, "java", "src/main/java/", "java路径"),
    XML(1, "xml", "src/main/resources/", "xml路径");
    private int code;
    private String type;
    private String path;
    private String desc;

    ResourceEnum(int code, String type, String path, String desc) {
        this.code = code;
        this.type = type;
        this.path = path;
        this.desc = desc;
    }}
