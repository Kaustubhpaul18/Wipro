package com.example.main;

import com.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student1 = (Student) context.getBean("student1");
        Student student2 = (Student) context.getBean("student2");

        student1.displayDetails();
        student2.displayDetails();
    }
}
