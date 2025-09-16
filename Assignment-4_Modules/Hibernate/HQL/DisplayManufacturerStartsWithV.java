import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class DisplayManufacturerStartsWithV {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(CarDetails.class)
                                .buildSessionFactory();
        Session session = factory.openSession();

        Query<String> query = session.createQuery("select c.manufacturer from CarDetails c where c.manufacturer like 'V%'", String.class);
        List<String> list = query.list();

        for (String manufacturer : list) {
            System.out.println("Manufacturer: " + manufacturer);
        }

        session.close();
        factory.close();
    }
}
