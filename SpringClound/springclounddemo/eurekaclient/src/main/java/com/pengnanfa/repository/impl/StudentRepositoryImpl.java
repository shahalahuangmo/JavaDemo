package com.pengnanfa.repository.impl;

import com.pengnanfa.entity.Student;
import com.pengnanfa.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private  static Map<Long,Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1l,new Student(1L,"张三",23));
        studentMap.put(1l,new Student(2L,"李四",23));
        studentMap.put(1l,new Student(3L,"王五",25));
    }

    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveAndUpdate(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }
}
