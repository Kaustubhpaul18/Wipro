import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class consumer {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2, 5, 8, 13, 21, 34, 55, 60, 77, 90));

        Consumer<Integer> printOddEven = n -> {
            if (n % 2 == 0) {
                System.out.println(n + " even");
            } else {
                System.out.println(n + " odd");
            }
        };

        numbers.forEach(printOddEven);
    }
}