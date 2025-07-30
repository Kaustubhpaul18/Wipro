import java.time.LocalTime;

public class TimeAfter25Minutes {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime after25 = now.plusMinutes(25);
        System.out.println("Current time: " + now);
        System.out.println("Time after 25 minutes: " + after25);
    }
}
