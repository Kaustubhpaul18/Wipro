import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class word {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(List.of(
            "level", "hello", "radar", "world", "madam",
            "java", "noon", "python", "civic", "kayak"
        ));

        Predicate<String> isPalindrome = s -> {
            StringBuilder sb = new StringBuilder(s);
            return s.equalsIgnoreCase(sb.reverse().toString());
        };

        System.out.println("Palindromic words:");
        words.stream()
             .filter(isPalindrome)
             .forEach(System.out::println);
    }
}