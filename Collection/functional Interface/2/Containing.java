import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class Containing {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(5, 8, 12, 3, 7, 9, 1, 4, 6, 10));

        // Function to calculate sum of elements in ArrayList
        Function<ArrayList<Integer>, Integer> sumFunction = list -> {
            int sum = 0;
            for (int num : list) {
                sum += num;
            }
            return sum;
        };

        int sum = sumFunction.apply(numbers);
        System.out.println("Sum of all elements: " + sum);
    }
}