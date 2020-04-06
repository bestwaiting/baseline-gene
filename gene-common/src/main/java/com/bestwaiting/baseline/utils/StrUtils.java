package com.bestwaiting.baseline.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

/**
 * StrUtils
 *
 * @author bestwaiting
 * @date 2020-03-31 13:46
 */
public class StrUtils {
    public static String splitJoinStr(String delimiteStr) {
        return WordUtils.capitalizeFully(delimiteStr, new char[]{'_'}).replace("_", "");
    }
    public static String lowerFirstStr(String str) {
        return StringUtils.uncapitalize(str);
    }
}
