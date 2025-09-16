package com.example.service;

import com.example.model.Student;
import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> getAllStudents();
}
