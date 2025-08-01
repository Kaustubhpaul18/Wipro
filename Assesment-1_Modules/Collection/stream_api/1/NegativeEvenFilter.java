import java.util.ArrayList;

public class NegativeEvenFilter {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(-5);
        numbers.add(-2);
        numbers.add(3);
        numbers.add(-4);
        numbers.add(6);

        ArrayList<Integer> negativeEvenNumbers = new ArrayList<>();

        for (int num : numbers) {
            if (num < 0 && num % 2 == 0) {
                negativeEvenNumbers.add(num);
            }
        }

        System.out.println("Negative even numbers: " + negativeEvenNumbers);
    }
}
