package com.example.hibernate;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class MainApp5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeWithAddress.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            Address addr = new Address("MG Road", "Bangalore", "Karnataka");
            EmployeeWithAddress emp = new EmployeeWithAddress("Anil", addr);
            session.beginTransaction();
            session.persist(emp);
            session.getTransaction().commit();
        } finally { factory.close(); }
    }
}