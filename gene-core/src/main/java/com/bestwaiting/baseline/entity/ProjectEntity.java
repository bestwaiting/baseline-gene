package com.bestwaiting.baseline.entity;

import com.bestwaiting.baseline.enums.ModuleTypeEnum;
import lombok.Data;

/**
 * 项目配置实体类
 *
 * @author bestwaiting
 * @date 2020-03-30 21:07
 */
@Data
public class ProjectEntity {
    /**
     * 作者
     */
    private String author = "baseline-gene";

    /**
     * 模块类型
     */
    private String moduleType = ModuleTypeEnum.SINGLE.getValue();

    /**
     * 应用包名
     */
    private String groupId;

    /**
     * 应用名称
     */
    private String artifactId;
}
