import java.util.ArrayList;

public class Square {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(4);
        numbers.add(7);
        numbers.add(9);
        numbers.add(16);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);
        numbers.add(36);
        numbers.add(50);

        for (int n : numbers) {
            if (isPerfectSquare(n)) {
                System.out.println(n);
            }
        }
    }

    public static boolean isPerfectSquare(int n) {
        if (n < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}