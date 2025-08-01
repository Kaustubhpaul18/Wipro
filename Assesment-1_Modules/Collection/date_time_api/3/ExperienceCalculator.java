import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ExperienceCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your joining date (YYYY-MM-DD): ");
        String joinDateStr = sc.nextLine();
        LocalDate joinDate = LocalDate.parse(joinDateStr);
        LocalDate today = LocalDate.now();

        Period experience = Period.between(joinDate, today);
        System.out.println("Experience: " + experience.getYears() + " years, "
                           + experience.getMonths() + " months, " + experience.getDays() + " days");
    }
}
