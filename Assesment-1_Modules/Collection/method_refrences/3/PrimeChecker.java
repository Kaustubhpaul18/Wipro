@FunctionalInterface
interface PrimeInterface {
    PrimeCheck check(int num);
}

class PrimeCheck {
    public PrimeCheck(int n) {
        if (n <= 1) {
            System.out.println(n + " is Not Prime");
            return;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println(n + " is Not Prime");
                return;
            }
        }
        System.out.println(n + " is Prime");
    }
}

public class PrimeChecker {
    public static void main(String[] args) {
        PrimeInterface pi = PrimeCheck::new;  // constructor reference
        pi.check(17);  // prints "17 is Prime"
        pi.check(20);  // prints "20 is Not Prime"
    }
}
