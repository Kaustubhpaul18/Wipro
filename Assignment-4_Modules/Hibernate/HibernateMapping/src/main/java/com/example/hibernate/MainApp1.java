package com.example.hibernate;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class MainApp1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(CarOwner.class).addAnnotatedClass(CarDetail.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            CarDetail car = new CarDetail("Swift", "Maruti");
            CarOwner owner = new CarOwner("Rahul", car);
            session.beginTransaction();
            session.persist(owner);
            session.getTransaction().commit();
        } finally { factory.close(); }
    }
}