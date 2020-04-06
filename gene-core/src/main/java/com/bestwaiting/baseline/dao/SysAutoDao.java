package com.bestwaiting.baseline.dao;



import com.bestwaiting.baseline.entity.ColumnEntity;
import com.bestwaiting.baseline.entity.TableEntity;

import java.util.List;


public interface SysAutoDao {
    /**
     * 查询该实力数据实例
     *
     * @return
     */
    List<String> queryDbs();

    /**
     * 根据数据库和表名查询部分数据表相关信息
     *
     * @param dbName     数据库名
     * @param tableNames 部分表名
     * @return
     */
    List<TableEntity> queryTablesByDbAndTables(String dbName, List<String> tableNames);


    /**
     * 查询数据表所有字段的相关信息
     *
     * @param dbName    数据库名
     * @param tableName 表名
     * @return 表中数据字段信息
     */
    List<ColumnEntity> queryColumnsByTable(String dbName, String tableName);

}
