package com.bestwaiting.baseline.enums;

import lombok.Getter;

/**
 * 数据来源枚举
 *
 * @author bestwaiting
 * @date 2020-03-30 21:02
 */
@Getter
public enum GeneDataSourceEnum {
    DB(0, "db", "数据库"),
    SQL(1, "sql", "建表语句");
    private int code;
    private String value;
    private String desc;

    GeneDataSourceEnum(int code, String value, String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }
}
