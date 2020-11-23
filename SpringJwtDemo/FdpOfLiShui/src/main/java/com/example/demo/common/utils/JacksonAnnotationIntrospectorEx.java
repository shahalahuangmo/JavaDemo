package com.example.demo.common.utils;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import java.lang.annotation.Annotation;

/**
 * 扩展JACKSON对FastJson注释JSONField的支持
 */
public class JacksonAnnotationIntrospectorEx extends JacksonAnnotationIntrospector
{
    @Override
    public  boolean isAnnotationBundle(Annotation annotation)
    {
        if (annotation.annotationType() == JSONField.class) {
            return true;
        }
        return super.isAnnotationBundle(annotation);
    }

    @Override
    public PropertyName findNameForSerialization(Annotated a) {
        PropertyName nameForSerialization = super.findNameForSerialization(a);
        if (nameForSerialization == null || nameForSerialization == PropertyName.USE_DEFAULT) {
            JSONField jsonField = _findAnnotation(a, JSONField.class);
            if (jsonField != null) {
                return PropertyName.construct(jsonField.name());
            }
        }
        return nameForSerialization;
    }

    @Override
    public PropertyName findNameForDeserialization(Annotated a) {
        PropertyName nameForDeserialization = super.findNameForDeserialization(a);
        if (nameForDeserialization == null || nameForDeserialization == PropertyName.USE_DEFAULT) {
            JSONField jsonField = _findAnnotation(a, JSONField.class);
            if (jsonField != null) {
                return PropertyName.construct(jsonField.name());
            }
        }
        return nameForDeserialization;
    }

}
