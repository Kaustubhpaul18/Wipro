import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class DisplayRegNoManufacturer {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(CarDetails.class)
                                .buildSessionFactory();
        Session session = factory.openSession();

        Query<Object[]> query = session.createQuery("select c.regNo, c.manufacturer from CarDetails c", Object[].class);
        List<Object[]> list = query.list();

        for (Object[] row : list) {
            System.out.println("RegNo: " + row[0] + " Manufacturer: " + row[1]);
        }

        session.close();
        factory.close();
    }
}
