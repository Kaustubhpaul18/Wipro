package com.example.hibernate;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class MainApp3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Continent.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            Continent asia = new Continent("Asia");
            asia.addCountry("India", "New Delhi");
            asia.addCountry("Japan", "Tokyo");
            session.beginTransaction();
            session.persist(asia);
            session.getTransaction().commit();
        } finally { factory.close(); }
    }
}