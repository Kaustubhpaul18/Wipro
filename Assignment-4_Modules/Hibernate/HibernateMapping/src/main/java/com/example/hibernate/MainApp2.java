package com.example.hibernate;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class MainApp2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(MultiCarOwner.class).addAnnotatedClass(CarDetail.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            MultiCarOwner owner = new MultiCarOwner("Suresh");
            owner.addCar(new CarDetail("i20", "Hyundai"));
            owner.addCar(new CarDetail("City", "Honda"));
            session.beginTransaction();
            session.persist(owner);
            session.getTransaction().commit();
        } finally { factory.close(); }
    }
}