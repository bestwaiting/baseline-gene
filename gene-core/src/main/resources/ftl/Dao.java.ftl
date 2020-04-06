package ${groupId}.${dao["packageName"]};

import ${groupId}.${base_dao["packageName"]}.${base_dao["suffix"]};
import ${groupId}.${entity["packageName"]}.${entityName}${entity["suffix"]};
import org.apache.ibatis.annotations.Mapper;

/**
* <#if tableComment??>${tableComment}</#if>
*
* @author <#if author??>${author}</#if>
* @date ${datetime}
*/
@Mapper
public interface ${entityName}${dao["suffix"]} extends BaseDao<${entityName}${entity["suffix"]}> {

}
