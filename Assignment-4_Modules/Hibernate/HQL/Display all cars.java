import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class DisplayAllCars {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(CarDetails.class)
                                .buildSessionFactory();
        Session session = factory.openSession();

        Query<CarDetails> query = session.createQuery("from CarDetails", CarDetails.class);
        List<CarDetails> cars = query.list();

        for (CarDetails c : cars) {
            System.out.println(c);
        }

        session.close();
        factory.close();
    }
}
