package com.example.service;

import com.example.dao.StudentDAO;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    @Override
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Transactional
    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
