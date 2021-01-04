package com.pengnanfa.controller;

import com.pengnanfa.entity.Student;
import com.pengnanfa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentRepository studentRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Student> findAll()
    {
        return studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id)
    {
        return studentRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student)
    {
        studentRepository.saveAndUpdate(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student)
    {
        studentRepository.saveAndUpdate(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id)
    {
        studentRepository.deleteById(id);
    }

    @GetMapping("/index")
    public String index(){
        return "当前端口："+ this.port;
    }
}
