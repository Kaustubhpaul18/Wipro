package com.wipro.dao;

import com.wipro.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDAO {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void addEmployee(Employee e) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(e);
        tx.commit();
        session.close();
    }

    public void deleteEmployee(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Employee e = session.get(Employee.class, id);
        if (e != null) session.delete(e);
        tx.commit();
        session.close();
    }

    public void updateEmployee(Employee e) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(e);
        tx.commit();
        session.close();
    }

    public Employee getEmployee(int id) {
        Session session = factory.openSession();
        Employee e = session.get(Employee.class, id);
        session.close();
        return e;
    }

    public List<Employee> getAllEmployees() {
        Session session = factory.openSession();
        List<Employee> list = session.createQuery("from Employee", Employee.class).list();
        session.close();
        return list;
    }
}
