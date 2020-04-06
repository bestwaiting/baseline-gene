<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${groupId}.${dao["packageName"]}.${entityName}${dao["suffix"]}">

    <!--结果集合-->
    <resultMap id="ResultMap" type="${groupId}.${entity["packageName"]}.${entityName}${entity["suffix"]}">
    <#list columns as column>
        <result property="${column.filedName}" column="${column.columnName}"/>
    </#list>
    </resultMap>
    
    <!--除主键外列集合-->
    <sql id="Column_PRI">
        <trim suffixOverrides=",">
    <#list columns as column>
        <#if column.columnName!= primaryKey.columnName>
            ${column.columnName}<#if column_has_next>,</#if>
        </#if>
    </#list>
        </trim>
    </sql>

    <!--列集合-->
    <sql id="Column_All">
        primaryKey.columnName ,
        <include refid="Column_PRI"/>
    </sql>

    <!--查询条件基础列-->
    <sql id="Where_All">
    <#list columns as column>
        <if test="condition.${column.filedName} != null">
            ${column.columnName} = ${r"#{condition."}${column.filedName}}<#if column_has_next> and</#if>
        </if>
    </#list>
    </sql>

    <!--插入非空列-->
    <sql id="Insert_NotNull_Columns">
        <trim suffixOverrides=",">
         <#list columns as column>
             <if test="condition.${column.filedName} != null">
                 ${column.columnName}<#if column_has_next>,</#if>
             </if>
         </#list>
        </trim>
    </sql>
    <!--插入非空列值-->
    <sql id="Insert_NotNull_Values">
        <trim suffixOverrides=",">
         <#list columns as column>
             <if test="condition.${column.filedName} != null">
                 ${r"#{condition."}${column.filedName}}<#if column_has_next>,</#if>
             </if>
         </#list>
        </trim>
    </sql>

    <!--批量插入全部列值-->
    <sql id="Insert_Batch">
        <trim suffixOverrides=",">
    <#list columns as column>
        <#if column.columnName!= primaryKey.columnName>
            ${r"#{condition."}${column.filedName}}<#if column_has_next>,</#if>
        </#if>
    </#list>
        </trim>
    </sql>

    <!--查询相关接口-->
    <select id="queryById" resultMap="ResultMap">
        select <include refid="Column_All"/>
        from ${tableName}
        where ${primaryKey.columnName} = ${r"#{id}"}
    </select>

    <select id="queryListByEntity" resultMap="ResultMap">
        select <include refid="Column_All"/>
        from ${tableName}
        <trim prefix="WHERE" suffixOverrides="and">
            <include refid="Where_All"/>
        </trim>
    </select>

    <select id="queryPageByEntity" resultMap="ResultMap">
        select <include refid="Column_All"/>
        from ${tableName}
        <trim prefix="WHERE" suffixOverrides="and">
            <include refid="Where_All"/>
        </trim>
    </select>

    <insert id="insert" parameterType="${groupId}.${entity["packageName"]}.${entityName}${entity["suffix"]}">
            useGeneratedKeys="true" keyProperty="condition.id" keyColumn="id">
        insert into ${tableName}
            (<include refid="Insert_NotNull_Columns"/>)
        values
            (<include refid="Insert_NotNull_Values"/>)
    </insert>

    <insert id="insertBatch" parameterType="java.util.List">
        insert into ${tableName}
            (<include refid="Column_PRI"/>)
        values
        <foreach collection="list" item="condition" index="index" separator=",">
            (
            <include refid="Insert_Batch"/>
            )
        </foreach>
    </insert>

    <!--更新相关接口-->
    <update id="updateById" parameterType="${groupId}.${entity["packageName"]}.${entityName}${entity["suffix"]}">
        update ${tableName}
        <trim prefix="set" suffixOverrides=",">
        <#list columns as column>
        <#if column.columnName!= primaryKey.columnName>
            <if test="condition.${column.filedName} != null">
                ${column.columnName}=${r"#{condition."}${column.filedName}}<#if column_has_next>,</#if>
            </if>
        </#if>
        </#list>
        </trim>
        where ${primaryKey.columnName} = ${r"#{condition."}${primaryKey.filedName}}
    </update>

    <!--删除相关接口-->
    <update id="deleteById">
        update ${tableName}
        set is_delete = 1
        where ${primaryKey.columnName} = ${r"#{id}"}
    </update>

    <update id="deleteBatchId">
        update ${tableName}
        set is_delete = 1
        where
        ${primaryKey.columnName} in
        <foreach item="id" collection="ids" open="(" separator="," close=")">
            id
        </foreach>
    </update>

</mapper>