package com.example.demo.system.mapper.basemapper;

import com.example.demo.system.model.domain.system.Function;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 系统功能 Mapper 接口
 */
public interface FunctionMapper {
    /**
     *  获取功能信息通过功能Id
     * @param functionCode 功能code
     * @return
     */
    @Select("select * from function where functionCode = #{functionCode}")
    Function getFunctionByCode(String functionCode);

    /**
     * 获取所有的功能信息
     * @return
     */
    @Select("select * from function")
    List<Function> selectAllFunction();
}
