package com.bestwaiting.baseline.entity;

import lombok.Data;

/**
 * 数据表字段实体类
 *
 * @author bestwaiting
 * @date 2020-03-30 20:40
 */
@Data
public class ColumnEntity {
    /**
     * 列名
     */
    private String columnName;
    /**
     * 列类型
     */
    private String columnType;
    /**
     * 列描述
     */
    private String columnComment;
    /**
     * 列索引
     */
    private String columnIndex;
    /**
     * 字段名
     */
    private String filedName;
    /**
     * 字段类型
     */
    private String filedType;
}
