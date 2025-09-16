import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

public class CountCarsByRegNo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(CarDetails.class)
                                .buildSessionFactory();
        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(CarDetails.class);
        criteria.setProjection(Projections.rowCount());

        Long count = (Long) criteria.uniqueResult();
        System.out.println("Total number of cars: " + count);

        session.close();
        factory.close();
    }
}
