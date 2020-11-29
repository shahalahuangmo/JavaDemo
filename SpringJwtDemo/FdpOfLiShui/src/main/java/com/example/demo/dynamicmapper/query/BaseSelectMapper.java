package com.example.demo.dynamicmapper.query;

import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;


public interface BaseSelectMapper<T> {

    /**
     *  根据主键Id,查询数据对象
     * @param clazz 类型
     * @param id 主键Id
     * @return
     */
    @SelectProvider(type= BaseSelectProvider.class, method="selectByPrimaryKey")
    T selectByPrimaryKey(Class<T> clazz, Object id);

    /**
     * 查询所有数据
     * @param clazz 类型
     * @return
     */
    @SelectProvider(type= BaseSelectProvider.class, method="selectAll")
    List<T> selectAll(Class<T> clazz);
}
