import java.time.LocalTime;

public class TimeBefore530 {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime before = now.minusHours(5).minusMinutes(30);
        System.out.println("Current time: " + now);
        System.out.println("Time before 5 hours 30 minutes: " + before);
    }
}
