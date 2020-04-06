package com.bestwaiting.baseline.service;

import com.bestwaiting.baseline.enums.TemplateEnum;
import com.bestwaiting.baseline.utils.FreemakerUtils;
import com.bestwaiting.baseline.utils.VelocityUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * DataTemplateService
 *
 * @author bestwaiting
 * @date 2020-03-30 22:14
 */
public class DataTemplateService {

    public String geneData4Template(String templateContext, Map<String, Object> params) {
        return geneData4Template(TemplateEnum.FREEMARKER.getValue(), templateContext, params);
    }

    public String geneData4Template(String templateEnum, String templateContext, Map<String, Object> params) {
        if (templateEnum.equals(TemplateEnum.FREEMARKER.getValue())) {
            return FreemakerUtils.stringGene(templateContext, params);
        }
        if (templateEnum.equals(TemplateEnum.VELOCITY.getValue())) {
            return VelocityUtils.stringGene(templateContext, params);
        }
        if (templateEnum.equals(TemplateEnum.BEELT.getValue())) {

        }
        return StringUtils.EMPTY;
    }
}
