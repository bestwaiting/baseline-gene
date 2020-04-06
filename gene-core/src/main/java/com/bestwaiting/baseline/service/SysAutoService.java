package com.bestwaiting.baseline.service;


import com.bestwaiting.baseline.entity.ColumnEntity;
import com.bestwaiting.baseline.entity.DataBaseEntity;
import com.bestwaiting.baseline.entity.TableEntity;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bestwaiting
 * Date 18/4/25
 */
public class SysAutoService {


    /**
     * 查询该实例数据库集合
     *
     * @return
     */
    public List<String> queryDbs(DataBaseEntity dataBaseEntity) {
        List<String> result = Lists.newArrayList();
        String url = String.format("%s:%d", dataBaseEntity.getHost(), dataBaseEntity.getPort());
        SqlSession sqlSession = MybatisUtil.getSqlSession(url, dataBaseEntity.getUsername(), dataBaseEntity.getPassword());
        result = sqlSession.selectList("com.bestwaiting.baseline.dao.SysAutoDao.queryDbs");
        sqlSession.close();
        return result;
    }

    /**
     * 查询该库数据表集合
     *
     * @param dataBaseEntity
     * @return
     */
    public List<TableEntity> queryTablesByDbAndTables(DataBaseEntity dataBaseEntity) {
        List<TableEntity> result = Lists.newArrayList();
        SqlSession sqlSession = getSqlSession(dataBaseEntity);
        result = queryTablesByDbAndTables(sqlSession, dataBaseEntity.getDbname(), dataBaseEntity.getTableNames());
        sqlSession.close();
        return result;
    }

    /**
     * 查询该表数据列集合
     *
     * @param dataBaseEntity
     * @return
     */
    public List<ColumnEntity> queryColumnsByTable(DataBaseEntity dataBaseEntity, String tableName) {
        List<ColumnEntity> result = Lists.newArrayList();
        SqlSession sqlSession = getSqlSession(dataBaseEntity);
        result = queryColumnsByTable(sqlSession, dataBaseEntity.getDbname(), tableName);
        sqlSession.close();
        return result;
    }

    public SqlSession getSqlSession(DataBaseEntity dataBaseEntity) {
        String url = String.format("%s:%d/%s", dataBaseEntity.getHost(), dataBaseEntity.getPort(),
                dataBaseEntity.getDbname());
        SqlSession sqlSession = MybatisUtil.getSqlSession(url, dataBaseEntity.getUsername(), dataBaseEntity.getPassword());
        return sqlSession;
    }


    public List<TableEntity> queryTablesByDbAndTables(SqlSession sqlSession, String dbName, List<String> tableNames) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dbName", dbName);
        paramMap.put("tableNames", tableNames);
        return sqlSession.selectList("com.bestwaiting.baseline.dao.SysAutoDao.queryTablesByDbAndTables", paramMap);
    }

    public List<ColumnEntity> queryColumnsByTable(SqlSession sqlSession, String dbName, String tableName) {

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dbName", dbName);
        paramMap.put("tableName", tableName);
        return sqlSession.selectList("com.bestwaiting.baseline.dao.SysAutoDao.queryColumnsByTable", paramMap);

    }

}
