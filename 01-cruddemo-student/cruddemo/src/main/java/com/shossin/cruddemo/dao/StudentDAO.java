package com.shossin.cruddemo.dao;

import com.shossin.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
