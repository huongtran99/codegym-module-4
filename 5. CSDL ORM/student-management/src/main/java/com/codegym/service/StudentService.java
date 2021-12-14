package com.codegym.service;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public void edit(Student student) {
        studentRepository.edit(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }
}
