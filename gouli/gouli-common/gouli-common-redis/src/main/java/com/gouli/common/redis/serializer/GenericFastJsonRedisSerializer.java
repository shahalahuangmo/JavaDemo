package com.gouli.common.redis.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 *  {@link RedisSerializer} FastJson Generic Impl
 * @author pengnanfa
 * @date 2021/1/16 23:50
 */
public class GenericFastJsonRedisSerializer implements RedisSerializer<Object> {
    private final static ParserConfig DEFAULT_REDIS_CONFIG = new ParserConfig();
    static {
        // 这里设置AutoType为True解决序列化失败autoType is not support的问题
        DEFAULT_REDIS_CONFIG.setAutoTypeSupport(true);}

    @Override
    public byte[] serialize(Object object) throws SerializationException {
        if (object == null) {
            return new byte[0];
        }
        try {
            return JSON.toJSONBytes(object, SerializerFeature.WriteClassName);
        } catch (Exception ex) {
            throw new SerializationException("Could not serialize: " + ex.getMessage(), ex);
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        try {
            return JSON.parseObject(new String(bytes, IOUtils.UTF8), Object.class, DEFAULT_REDIS_CONFIG);
        } catch (Exception ex) {
            throw new SerializationException("Could not deserialize: " + ex.getMessage(), ex);
        }
    }
}

