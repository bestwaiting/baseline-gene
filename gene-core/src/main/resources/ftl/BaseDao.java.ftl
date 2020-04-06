package ${groupId}.${base_dao["packageName"]};

import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ${base_dao["suffix"]}<T> {

    T queryById(@Param("id") long id);

    List<T> queryListByEntity(@Param("condition") T entity);

    Integer insertBatch(@Param("list") List<T> list);

    Integer insert(@Param("condition") T entity);

    Integer updateById(@Param("condition") T entity);

    Integer deleteById(@Param("id") long id);

    Integer deleteBatchId(@Param("ids") List<Long> id);
}
