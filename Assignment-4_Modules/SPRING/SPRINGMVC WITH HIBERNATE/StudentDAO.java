package com.example.dao;

import java.util.List;
import com.example.model.Student;

public interface StudentDAO {
    void saveStudent(Student student);
    List<Student> getAllStudents();
}
