package com.example.demo.dynamicmapper.insert;


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static com.gitee.sunchenbin.mybatis.actable.utils.ColumnUtils.*;

public class BaseInsertProvider {

    /**
     *  根据主键Id,更新数据对象
     * @param bean 更新数据对象
     * @return
     */
    public String insert(Object bean)  {
        //获取表名
        Class<?> clazz = bean.getClass();
        String tableName = getTableName(clazz);
        SQL sql = new SQL();
        sql.INSERT_INTO(tableName);
        //获取所有的字段
        while (clazz != null && clazz != Object.class) {
            for (Field field : clazz.getDeclaredFields())
            {
                if (Modifier.isPrivate(field.getModifiers()))
                {
                    String columnName = getColumnName(field);
                    if(!StringUtils.isEmpty(columnName))
                    {
                        field.setAccessible(true);
                        try {
                            Object value = field.get(bean);
                            if(value != null && !StringUtils.isEmpty(value.toString()))
                            {
                                if(!isKey(field))
                                {
                                    sql.VALUES("`" + columnName + "`", "#{" + columnName + "}");
                                }
                            }
                        }catch (IllegalAccessException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
        return sql.toString();
    }
}
