package com.bestwaiting.baseline.entity;

import lombok.Data;

import java.util.List;

/**
 * GeneParamsEntity
 *
 * @author bestwaiting
 * @date 2020-03-31 10:00
 */
@Data
public class GeneParamsEntity extends ProjectEntity {

    /**
     * 模块分层列表
     */
    private List<TemplateEntity> modules;

    /**
     * 待生成数据表集合
     */
    private List<TableEntity> tables;
}
