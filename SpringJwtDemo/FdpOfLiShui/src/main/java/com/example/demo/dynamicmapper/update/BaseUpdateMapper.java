package com.example.demo.dynamicmapper.update;

import com.example.demo.dynamicmapper.query.BaseSelectProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;


public interface BaseUpdateMapper {

    /**
     *  根据主键Id,查询数据对象
     * @param bean 数据对象
     * @return
     */
    @UpdateProvider(type= BaseUpdateProvider.class, method="update")
    int update(Object bean);
}
