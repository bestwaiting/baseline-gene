package com.bestwaiting.baseline.entity;

import lombok.Data;

/**
 * TemplateEntity
 *
 * @author bestwaiting
 * @date 2020-03-31 09:57
 */
@Data
public class TemplateEntity {
    private String templateType;
    private String templateName;
    private String structureType;
    private String beanNameSuffix;
    private String templateContext;
    private String moduleName;
    private String packageName;
    private int useRates;
    private String fileType;
}
