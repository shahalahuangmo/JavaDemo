package com.example.demo.dynamicmapper.update;

import com.example.demo.dynamicmapper.query.BaseSelectProvider;
import org.apache.ibatis.annotations.SelectProvider;


public interface BaseUpdateMapper {

    /**
     *  根据主键Id,查询数据对象
     * @param bean 数据对象
     * @return
     */
    @SelectProvider(type= BaseSelectProvider.class, method="selectByPrimaryKey")
    int update(Object bean);
}
