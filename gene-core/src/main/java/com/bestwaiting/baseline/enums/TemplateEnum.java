package com.bestwaiting.baseline.enums;

import lombok.Getter;

/**
 * TemplateEnum
 *
 * @author bestwaiting
 * @date 2020-03-30 22:31
 */
@Getter
public enum TemplateEnum {
    FREEMARKER(0, "freemaker"),
    VELOCITY(1, "velocity"),
    BEELT(2, "beelt");
    private int code;
    private String value;

    TemplateEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
