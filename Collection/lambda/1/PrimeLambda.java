import java.util.*;
import java.util.stream.*;

public class PrimeLambda {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 25; i++) {
            al.add(rand.nextInt(100)); // Random numbers between 0 and 99
        }

        System.out.println("All numbers: " + al);
        System.out.println("Prime numbers:");

        al.stream()
          .filter(PrimeLambda::isPrime)
          .forEach(System.out::println);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        return IntStream.rangeClosed(2, (int)Math.sqrt(num))
                        .allMatch(n -> num % n != 0);
    }
}
