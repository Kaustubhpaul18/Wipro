import java.time.Year;

public class LeapYearCheck {
    public static void main(String[] args) {
        int currentYear = Year.now().getValue();
        boolean isLeap = Year.isLeap(currentYear);
        System.out.println("Current year: " + currentYear);
        System.out.println("Is leap year? " + isLeap);
    }
}
