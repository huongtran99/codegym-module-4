package com.codegym.service;

import com.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    void delete(Long id);

    void edit(Student student);

    Student findById(Long id);

    List<Student> findByName(String name);
}
