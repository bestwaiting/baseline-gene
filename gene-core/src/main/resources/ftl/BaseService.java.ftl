package ${groupId}.${base_service["packageName"]};

import ${groupId}.${base_dao["packageName"]};

/**
 * ${base_service["suffix"]}
 *
 * @author <#if author??>${author}</#if>
 * @date ${datetime}
 */
public interface ${base_service["suffix"]}<T> extends ${base_dao["suffix"]}<T>{

}
