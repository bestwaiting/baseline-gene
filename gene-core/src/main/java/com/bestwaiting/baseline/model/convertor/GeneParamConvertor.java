package com.bestwaiting.baseline.model.convertor;

import com.bestwaiting.baseline.common.GeneConstats;
import com.bestwaiting.baseline.entity.*;
import com.bestwaiting.baseline.enums.StructureEnum;
import com.bestwaiting.baseline.enums.TemplateEnum;
import com.bestwaiting.baseline.model.dto.LocalGeneParamsDto;
import com.bestwaiting.baseline.service.SysAutoService;
import com.bestwaiting.baseline.utils.FileUtils;
import com.bestwaiting.baseline.utils.StrUtils;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * GeneParamConvertor
 *
 * @author bestwaiting
 * @date 2020-03-31 11:52
 */
public class GeneParamConvertor {

    public GeneParamsEntity local2Gene(LocalGeneParamsDto paramsDto) {
        GeneParamsEntity geneParamsEntity = new GeneParamsEntity();
        geneParamsEntity.setAuthor(paramsDto.getAuthor());
        geneParamsEntity.setModuleType(paramsDto.getModuleType());
        geneParamsEntity.setGroupId(paramsDto.getGroupId());
        geneParamsEntity.setArtifactId(paramsDto.getArtifactId());

        geneParamsEntity.setModules(geneTemplates(paramsDto.getStructures()));

        DataBaseEntity dataBaseEntity = new DataBaseEntity();
        dataBaseEntity.setHost(paramsDto.getHost());
        dataBaseEntity.setPort(paramsDto.getPort());
        dataBaseEntity.setDbname(paramsDto.getDbname());
        dataBaseEntity.setUsername(paramsDto.getUsername());
        dataBaseEntity.setPassword(paramsDto.getPassword());
        dataBaseEntity.setTableNames(paramsDto.getTableNames());
        geneParamsEntity.setTables(assemble(dataBaseEntity));
        return geneParamsEntity;
    }

    private List<TemplateEntity> geneTemplates(List<String> structures) {
        List<TemplateEntity> modules = Lists.newArrayList();
        if (CollectionUtils.isEmpty(structures)) {
            for (StructureEnum structureEnum : StructureEnum.values()) {
                structures.add(structureEnum.getKey());
            }
        }
        for (String key : structures) {
            StructureEnum structureEnum = StructureEnum.getByKey(key);
            if (structureEnum == null) {
                continue;
            }
            TemplateEntity templateEntity = new TemplateEntity();
            templateEntity.setTemplateType(TemplateEnum.FREEMARKER.getValue());
            templateEntity.setTemplateName(structureEnum.getKey());
            templateEntity.setStructureType(structureEnum.getKey());
            templateEntity.setBeanNameSuffix(structureEnum.getValue());
            templateEntity.setModuleName(structureEnum.getModule());
            templateEntity.setPackageName(structureEnum.getPackageStr());
            templateEntity.setTemplateContext(FileUtils.readFile(structureEnum.getLocalFile()));
            templateEntity.setUseRates(structureEnum.getUseRates());
            templateEntity.setFileType(structureEnum.getFileType());
            modules.add(templateEntity);
        }
        return modules;
    }

    private List<TableEntity> assemble(DataBaseEntity dataBaseEntity) {
        SysAutoService sysAutoService = new SysAutoService();
        SqlSession sqlSession = sysAutoService.getSqlSession(dataBaseEntity);
        List<TableEntity> result = sysAutoService.queryTablesByDbAndTables(sqlSession, dataBaseEntity.getDbname(),
                dataBaseEntity.getTableNames());
        if (CollectionUtils.isNotEmpty(result)) {
            for (TableEntity tableEntity : result) {
                tableEntity.setEntityName(StrUtils.splitJoinStr(tableEntity.getTableName()));
                tableEntity.setEntityNameLower(StrUtils.lowerFirstStr(tableEntity.getEntityName()));
                List<ColumnEntity> columnEntities = sysAutoService.queryColumnsByTable(sqlSession, dataBaseEntity.getDbname(),
                        tableEntity.getTableName());
                if (CollectionUtils.isEmpty(columnEntities)) {
                    continue;
                }
                for (ColumnEntity columnEntity : columnEntities) {
                    columnEntity.setFiledName(StrUtils.lowerFirstStr(StrUtils.splitJoinStr(columnEntity.getColumnName())));
                    columnEntity.setFiledType(GeneConstats.dataTypeMap.get(columnEntity.getColumnType()));
                    if ("PRI".equalsIgnoreCase(columnEntity.getColumnIndex()) && tableEntity.getPrimaryKey() == null) {
                        tableEntity.setPrimaryKey(columnEntity);
                    }
                }
                if (tableEntity.getPrimaryKey() == null) {
                    tableEntity.setPrimaryKey(tableEntity.getColumns().get(0));
                }
                tableEntity.setColumns(columnEntities);
            }
        }
        sqlSession.close();
        return result;
    }


}
