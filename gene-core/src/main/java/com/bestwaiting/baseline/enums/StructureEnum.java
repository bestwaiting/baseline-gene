package com.bestwaiting.baseline.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 应用分层枚举类
 *
 * @author bestwaiting
 * @date 2020-03-30 21:49
 */
@Getter
public enum StructureEnum {
//    COMMON(0, "common", "", "common", "common", "公共模块", ""),
    BASE_DAO(1,1, "base_dao", "BaseDao", "common", "core", "数据库定义接口", "ftl/BaseDao.java.ftl","java"),
    BASE_MAPPER(2, 2,"base_mapper", "BaseMapper", "mapper", "core", "数据库定义实现", "ftl/BaseDao.xml.ftl","xml"),
    BASE_SERVICE(3, 1,"base_service", "BaseService", "common", "core", "数据库操作接口", "ftl/BaseService.java.ftl","java"),
    BASE_SERVICE_IMPL(4, 1,"base_service_impl", "BaseServiceImpl", "service.impl", "core", "数据库操作实现", "ftl" +
            "/BaseServiceImpl.java.ftl","java"),
    ENTITY(5, 2,"entity", "Entity", "entity", "core", "实体对象", "ftl/Entity.java.ftl","java"),
    DAO(6, 2,"dao", "Dao", "dao", "core", "数据库定义接口", "ftl/Dao.java.ftl","java"),
    MAPPER(7, 2,"mapper", "Mapper", "mapper", "core", "数据库定义实现", "ftl/Dao.xml.ftl","xml"),
    SERVICE(8, 2,"service", "Service", "service", "core", "数据操作接口", "ftl/Service.java.ftl","java"),
    SERVICE_IMPL(9, 2,"service_impl", "ServiceImpl", "service.impl", "core", "数据操作实现", "ftl/ServiceImpl.java.ftl",
            "java"),
    CONTROLLER(10, 2,"controller", "Controller", "controller", "web", "应用模块", "ftl/Controller.java.ftl","java");
    private int code;
    private int useRates;
    private String key;
    private String value;
    private String packageStr;
    private String module;
    private String desc;
    private String localFile;
    private String fileType;

    StructureEnum(int code, int useRates, String key, String value, String packageStr, String module, String desc, String localFile, String fileType) {
        this.code = code;
        this.useRates = useRates;
        this.key = key;
        this.value = value;
        this.packageStr = packageStr;
        this.module = module;
        this.desc = desc;
        this.localFile = localFile;
        this.fileType = fileType;
    }

    public static StructureEnum getByKey(String key){
        if (StringUtils.isBlank(key)){
            return null;
        }
        for (StructureEnum structureEnum:StructureEnum.values()){
            if (key.equals(structureEnum.getKey())){
                return structureEnum;
            }
        }
        return null;
    }
}
