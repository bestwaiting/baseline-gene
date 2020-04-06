package ${groupId}.${service_impl["packageName"]};

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import ${groupId}.${base_service_impl["packageName"]};
import ${groupId}.${entity["packageName"]}.${entityName}${entity["suffix"]};
import ${groupId}.${dao["packageName"]}.${entityName}${dao["suffix"]};

/**
 * <#if comments??>${comments}</#if>
 *
 * @author <#if author??>${author}</#if>
 * @date ${datetime}
 */
@Service("${entityNameLower}${service["suffix"]}")
public class  ${entityName}${service_impl["suffix"]} extends
${base_service_impl["suffix"]}<${entityName}${dao["suffix"]},${entityName}${entity["suffix"]}> implements
${entityName}${service["suffix"]} {


}
