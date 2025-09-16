package com.example.hibernate;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class MainApp4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Passport.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            Employee emp = new Employee("Ramesh", new Passport("X12345"));
            session.beginTransaction();
            session.persist(emp);
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee e = session.get(Employee.class, 1);
            if(e != null) session.remove(e);
            session.getTransaction().commit();
        } finally { factory.close(); }
    }
}