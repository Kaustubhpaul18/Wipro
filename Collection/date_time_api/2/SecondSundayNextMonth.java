import java.time.DayOfWeek;
import java.time.LocalDate;

public class SecondSundayNextMonth {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue() + 1;

        if (month > 12) {
            month = 1;
            year++;
        }

        LocalDate firstDay = LocalDate.of(year, month, 1);
        int sundayCount = 0;

        for (int i = 0; i < 31; i++) {
            LocalDate current = firstDay.plusDays(i);
            if (current.getMonthValue() != month) break;
            if (current.getDayOfWeek() == DayOfWeek.SUNDAY) {
                sundayCount++;
                if (sundayCount == 2) {
                    System.out.println("Second Sunday of next month: " + current);
                    break;
                }
            }
        }
    }
}
