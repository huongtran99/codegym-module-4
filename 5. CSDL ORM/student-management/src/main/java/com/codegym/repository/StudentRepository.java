package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepository implements IStudentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student as s", Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Student student) {
        if (student.getId() != null) {
            entityManager.merge(student);
        } else {
            entityManager.persist(student);
        }
    }

    @Override
    public void delete(Long id) {
        Student student = findById(id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public void edit(Student student) {
        entityManager.merge(student);
    }

    @Override
    public Student findById(Long id) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student as s where s.id = :id", Student.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student as s where s.name like concat('%',?1,'%')", Student.class);
        query.setParameter(1, name);
        return query.getResultList();
    }
}
