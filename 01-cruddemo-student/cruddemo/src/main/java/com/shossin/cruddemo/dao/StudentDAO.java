package com.shossin.cruddemo.dao;

import com.shossin.cruddemo.entity.Student;

import java.security.SecureRandom;
import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);
}
