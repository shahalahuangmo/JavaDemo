package com.example.demo.dynamicmapper.insert;

import com.example.demo.dynamicmapper.query.BaseSelectProvider;
import org.apache.ibatis.annotations.SelectProvider;


public interface BaseInsertMapper {

    /**
     *  根据主键Id,查询数据对象
     * @param bean 数据对象
     * @return
     */
    @SelectProvider(type= BaseSelectProvider.class, method="selectByPrimaryKey")
    int insert(Object bean);
}
