package com.example.demo.service.base;

import java.util.HashMap;

public interface BaseService {
    public int insert(Object obj);

    public HashMap query(long id, Class c);

    public int update(Object obj);

    public int delete(Object obj);
}
