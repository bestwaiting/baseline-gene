package com.bestwaiting.baseline.entity;

import lombok.Data;

import java.util.List;

/**
 * 数据表实体类
 *
 * @author bestwaiting
 * @date 2020-03-30 20:53
 */
@Data
public class TableEntity {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableComment;

    /**
     * 实体对象
     */
    private String entityName;

    /**
     * 实体实例
     */
    private String entityNameLower;

    /**
     * 表主键
     */
    private ColumnEntity primaryKey;

    /**
     * 表字段列表
     */
    private List<ColumnEntity> columns;
}
