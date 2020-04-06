package com.bestwaiting.baseline.enums;

import lombok.Getter;

/**
 * ModuleTypeEnum
 *
 * @author bestwaiting
 * @date 2020-03-30 21:24
 */
@Getter
public enum ModuleTypeEnum {
    SINGLE(0, "single", "单模块应用"),
    MULTI(1, "multi", "多模块应用");
    private int code;
    private String value;
    private String desc;

    ModuleTypeEnum(int code, String value, String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }
}
