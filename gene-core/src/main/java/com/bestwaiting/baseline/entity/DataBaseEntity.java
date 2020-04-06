package com.bestwaiting.baseline.entity;

import com.bestwaiting.baseline.enums.GeneDataSourceEnum;
import lombok.Data;

import java.util.List;

/**
 * 数据库实体类
 *
 * @author bestwaiting
 * @date 2020-03-30 21:19
 */
@Data
public class DataBaseEntity {

    /**
     * 数据来源类型
     */
    private String dataSourceType = GeneDataSourceEnum.DB.getValue();

    /**
     * 数据库地址
     */
    private String host;

    /**
     * 数据库端口
     */
    private int port = 3306;

    /**
     * 数据库名称
     */
    private String dbname;

    /**
     * 数据库用户名
     */
    private String username;

    /**
     * 数据库密码
     */
    private String password;

    /**
     * 数据表集合
     */
    private List<String> tableNames;

    /**
     * 建表语句
     */
    private String schemesSql;
}
