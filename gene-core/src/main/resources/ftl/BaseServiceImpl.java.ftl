package ${groupId}.${base_service_impl["packageName"]};

import java.util.List;
import javax.annotation.Resource;

import package ${groupId}.${dao["packageName"]}.${entityName}${dao["suffix"]};
import ${groupId}.${entity["packageName"]}.${entityName}${entity["suffix"]};

/**
 * <#if tableComment??>${tableComment}</#if>
 *
 * @author <#if author??>${author}</#if>
 * @date ${datetime}
 */
public abstract class ${base_service_impl["packageName"]}<M extends ${base_dao["suffix"]}<T>,T> implements ${base_service["suffix"]}<T> {

    @Resource
    protected M baseDao;

    /**
     * 插入一条记录
     *
     * @param T
     * @return
     */
    public int insert(T entity) {
        return baseDao.insert(entity);
    }

    /**
     * 批量插入记录
     *
     * @param list
     * @return
     */
    public int insertBatch(List<T> list) {
        return baseDao.insertBatch(list);
    }

    /**
    * 根据主键更新记录
    *
    * @param T
    * @return
    */
    public int updateById(T entity) {
        return baseDao.update(entity);
    }

    /**
    * 根据主键删除记录
    *
    * @param id
    * @return
    */
    public int deleteById(Long id) {
        return baseDao.deleteById(id);
    }

    /**
    * 根据主键批量删除记录
    *
    * @param ids
    * @return
    */
    public int deleteBatchId(List<Long> ids) {
        return baseDao.deleteBatchId(ids);
    }

    /**
    * 根据主键查询记录
    *
    * @param id
    * @return
    */
    public T queryById(long id) {
        return baseDao.queryById(id);
    }

    /**
    * 根据T查询记录列表
    *
    * @param T
    * @return
    */
    public List<T> queryListByEntity(T entity) {
        return baseDao.queryListByEntity(entity);
    }
}
