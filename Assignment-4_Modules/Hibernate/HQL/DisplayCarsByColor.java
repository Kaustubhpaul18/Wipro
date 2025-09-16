import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class DisplayCarsByColor {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(CarDetails.class)
                                .buildSessionFactory();
        Session session = factory.openSession();

        Criteria criteria = session.createCriteria(CarDetails.class);
        criteria.add(Restrictions.eq("color", "White"));  // change color as needed

        List<CarDetails> cars = criteria.list();
        for (CarDetails car : cars) {
            System.out.println(car);
        }

        session.close();
        factory.close();
    }
}
