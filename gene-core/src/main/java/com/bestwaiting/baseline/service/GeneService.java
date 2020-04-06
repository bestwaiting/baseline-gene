package com.bestwaiting.baseline.service;

import com.bestwaiting.baseline.entity.GeneParamsEntity;
import com.bestwaiting.baseline.entity.TableEntity;
import com.bestwaiting.baseline.entity.TemplateEntity;
import com.bestwaiting.baseline.enums.ModuleTypeEnum;
import com.bestwaiting.baseline.enums.ResourceEnum;
import com.bestwaiting.baseline.model.convertor.GeneParamConvertor;
import com.bestwaiting.baseline.model.dto.LocalGeneParamsDto;
import com.bestwaiting.baseline.utils.FileUtils;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * GeneService
 *
 * @author bestwaiting
 * @date 2020-03-31 11:51
 */
public class GeneService {

    public void geneCode4Local(LocalGeneParamsDto geneParamsDto) {
        GeneParamConvertor convertor = new GeneParamConvertor();
        geneCode(convertor.local2Gene(geneParamsDto));
    }

    public void geneCode(GeneParamsEntity paramsEntity) {
        if (CollectionUtils.isEmpty(paramsEntity.getModules()) || CollectionUtils.isEmpty(paramsEntity.getTables())) {
            return;
        }
        DataTemplateService dataTemplateService = new DataTemplateService();
        boolean moduleFlag = paramsEntity.getModuleType().equals(ModuleTypeEnum.SINGLE.getValue()) ? false : true;
        Map<String, Object> baseParams = getBaseParams(paramsEntity);
        for (TableEntity tableEntity : paramsEntity.getTables()) {
            Map<String, Object> tableParams = getTableParams(tableEntity);
            tableParams.putAll(baseParams);
            for (TemplateEntity templateEntity : paramsEntity.getModules()) {
                String geneCode = dataTemplateService.geneData4Template(templateEntity.getTemplateType(),
                        templateEntity.getTemplateContext(), tableParams);
                String filePath = getCodePath(moduleFlag, tableParams, templateEntity);
                if (StringUtils.isBlank(filePath)) {
                    continue;
                }
                File file = new File(filePath);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                FileUtils.createFile(file, geneCode);
            }
        }

    }

    private String getCodePath(boolean moduleFlag, Map<String, Object> tableParams, TemplateEntity templateEntity) {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append(tableParams.get("artifactId")).append("/");
        if (moduleFlag) {
            pathBuilder.append(templateEntity.getModuleName()).append("/");
        }
        if (templateEntity.getFileType().equals(ResourceEnum.JAVA.getType())) {
            pathBuilder.append(ResourceEnum.JAVA.getPath());
        } else {
            pathBuilder.append(ResourceEnum.XML.getPath());
        }

        StringBuilder pkgBuilder = new StringBuilder();
        pkgBuilder.append(tableParams.get("groupId")).append(".");
        if (moduleFlag) {
            pkgBuilder.append(templateEntity.getModuleName()).append(".");
        }
        pkgBuilder.append(templateEntity.getPackageName()).append(".")
                .append(templateEntity.getUseRates() == 1 ? "" : tableParams.get("entityName"))
                .append(templateEntity.getBeanNameSuffix());
        return (pathBuilder.toString() + pkgBuilder.toString()).replace(".", "/")
                + "." + templateEntity.getFileType();
    }

    private Map<String, Object> getTableParams(TableEntity tableEntity) {
        Map<String, Object> tableParams = Maps.newHashMap();
        tableParams.put("tableName", tableEntity.getTableName());
        tableParams.put("tableComment", tableEntity.getTableComment());
        tableParams.put("entityName", tableEntity.getEntityName());
        tableParams.put("entityNameLower", tableEntity.getEntityNameLower());
        tableParams.put("primaryKey", tableEntity.getPrimaryKey());
        tableParams.put("columns", tableEntity.getColumns());
        return tableParams;
    }

    private Map<String, Object> getBaseParams(GeneParamsEntity paramsEntity) {
        Map<String, Object> baseParams = Maps.newHashMap();
        baseParams.put("author", paramsEntity.getAuthor());
        baseParams.put("moduleType", paramsEntity.getModuleType());
        baseParams.put("groupId", paramsEntity.getGroupId());
        baseParams.put("artifactId", paramsEntity.getArtifactId());
        baseParams.put("datetime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        for (TemplateEntity templateEntity : paramsEntity.getModules()) {
            Map<String, String> template = Maps.newHashMap();
            template.put("suffix", templateEntity.getBeanNameSuffix());
            template.put("packageName", templateEntity.getPackageName());
            if (paramsEntity.getModuleType().equals(ModuleTypeEnum.MULTI.getValue())) {
                template.put("packageName", templateEntity.getModuleName() + "." + templateEntity.getPackageName());
            }
            baseParams.put(templateEntity.getStructureType(), template);
        }
        return baseParams;
    }
}
