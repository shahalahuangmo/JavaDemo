package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author pengnanfa
 * @date 2021/5/23 12:02
 */

public class Cache {
    static Map<String, Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock readLock = rwl.readLock();
    static Lock writeLock = rwl.writeLock();

    // 获取一个key对应的value
    public static final Object get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    // 设置key对应的value，并返回旧的value
    public static final Object put(String key, Object value) {
        writeLock.lock();

        try {
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    // 清空所有的内容
    public static final void clear() {
        writeLock.lock();

        try {
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }

    private  boolean update =false;

    public void processData() {
        readLock.lock();
        if (!update) {
            // 必须先释放读锁
            readLock.unlock();
            // 锁降级从写锁获取到开始
            writeLock.lock();
            try {
                if (!update) {
                    // 准备数据的流程（略）
                    update = true;
                }
                readLock.lock();
            } finally {
                writeLock.unlock();
            }
            // 锁降级完成，写锁降级为读锁
        }
        try {
            // 使用数据的流程（略）
        } finally {
            readLock.unlock();
        }
    }
}
