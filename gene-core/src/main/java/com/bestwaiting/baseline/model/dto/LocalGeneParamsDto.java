package com.bestwaiting.baseline.model.dto;

import com.bestwaiting.baseline.entity.ProjectEntity;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * LocalGeneParamsDto
 *
 * @author bestwaiting
 * @date 2020-03-31 11:49
 */
@Data
public class LocalGeneParamsDto extends ProjectEntity {

    List<String> structures;

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
}
