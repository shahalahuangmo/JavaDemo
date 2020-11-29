package com.example.demo.dynamicmapper.query;


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static com.gitee.sunchenbin.mybatis.actable.utils.ColumnUtils.*;

public class BaseSelectProvider {

    /**
     *  根据主键Id,查询数据对象
     * @param clazz 类型
     * @param id 主键Id
     * @return
     */
    public String selectByPrimaryKey(Class<?> clazz,Object id) {
        //获取表名
        String tableName = getTableName(clazz);
        //获取所有的字段
        final List<String> columns = new ArrayList();
        String primaryKey = null;
        while (clazz != null && clazz != Object.class) {
            for (Field field : clazz.getDeclaredFields())
            {
                if (Modifier.isPrivate(field.getModifiers()))
                {
                    String columnName = getColumnName(field);
                    if(!StringUtils.isEmpty(columnName))
                    {
                        columns.add("`" + columnName + "`");
                        if(isKey(field))
                        {
                            primaryKey = "`" + getColumnName(field) + "`";
                        }
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }

        SQL sql = new SQL();
        sql.SELECT(StringUtils.join(columns,','));
        sql.FROM(tableName);
        if(id != null)
        {
            sql.WHERE(primaryKey + " = #{id}");
        }
        return sql.toString();
    }

    /**
     * 查询所有数据
     * @param clazz 类型
     * @return
     */
    public String selectAll(Class<?> clazz) {
        //获取表名
        String tableName = getTableName(clazz);
        //获取所有的字段
        final List<String> columns = new ArrayList();
        while (clazz != null && clazz != Object.class) {
            for (Field field : clazz.getDeclaredFields())
            {
                if (Modifier.isPrivate(field.getModifiers()))
                {
                    String columnName = getColumnName(field);
                    if(!StringUtils.isEmpty(columnName))
                    {
                        columns.add("`" + columnName + "`");
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }

        SQL sql = new SQL();
        sql.SELECT(StringUtils.join(columns,','));
        sql.FROM(tableName);
        return sql.toString();
    }
}
