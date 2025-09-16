import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class DisplayCarByRegNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Registration Number: ");
        String reg = sc.nextLine();

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                .addAnnotatedClass(CarDetails.class)
                                .buildSessionFactory();
        Session session = factory.openSession();

        Query<CarDetails> query = session.createQuery("from CarDetails c where c.regNo = :reg", CarDetails.class);
        query.setParameter("reg", reg);
        CarDetails car = query.uniqueResult();

        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("No car found with RegNo: " + reg);
        }

        session.close();
        factory.close();
        sc.close();
    }
}
