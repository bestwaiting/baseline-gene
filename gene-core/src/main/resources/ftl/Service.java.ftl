package ${groupId}.${service["packageName"]};

import ${groupId}.${base_service["packageName"]}.${base_service["suffix"]};
import ${groupId}.${entity["packageName"]}.${entityName}${entity["suffix"]}
import java.util.List;

/**
 * <#if tableComment??>${tableComment}</#if>
 *
 * @author <#if author??>${author}</#if>
 * @date ${datetime}
 */
public interface ${entityName}${service["suffix"]} extends ${base_service["suffix"]}<${entityName}${entity["suffix"]}> {

}
