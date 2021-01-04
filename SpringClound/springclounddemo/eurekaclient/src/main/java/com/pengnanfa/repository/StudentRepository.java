package com.pengnanfa.repository;

import com.pengnanfa.entity.Student;

import java.util.Collection;

public interface StudentRepository {

   public Collection<Student> findAll();

   public Student findById(long id);

   public void saveAndUpdate(Student student);

   public void deleteById(long id);
}
