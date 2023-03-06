package com.korsuk.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface StudentDAO {

    Student findById(Long id);
    Student findByName(String name);
    List<Student> findAll();

    void save(Student student);

    void update(Long id, String name);

    void deleteById(Long id);
}
