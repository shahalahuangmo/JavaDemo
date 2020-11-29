package com.example.demo.dynamicmapper;

import com.example.demo.dynamicmapper.insert.BaseInsertMapper;
import com.example.demo.dynamicmapper.query.BaseSelectMapper;
import com.example.demo.dynamicmapper.update.BaseUpdateMapper;

public interface BaseMapper<T> extends BaseSelectMapper<T>, BaseInsertMapper, BaseUpdateMapper {
}
