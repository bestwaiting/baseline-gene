package ${groupId}.${entity["packageName"]};

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <#if comments??>${tableComment}</#if>
 *
 * @author <#if author??>${author}</#if>
 * @date ${datetime}
 */
@Data
public class ${entityName}${entity["suffix"]} implements Serializable {
    private static final long serialVersionUID = 1L;

<#list columns as column>
    /**
     * <#if column.columnComment??>${column.columnComment}</#if>
     */
    <#if column.columnName=="is_delete">
    private ${column.filedType} ${column.filedName} = 0;
    <#else >
    private ${column.filedType} ${column.filedName};
    </#if>

</#list>

}
