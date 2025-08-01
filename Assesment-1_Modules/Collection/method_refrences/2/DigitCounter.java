@FunctionalInterface
interface DigitCount {
    int count(int n);
}

class DigitUtil {
    public static int digitCount(int n) {
        return String.valueOf(Math.abs(n)).length();
    }
}

public class DigitCounter {
    public static void main(String[] args) {
        DigitCount dc = DigitUtil::digitCount;  // method reference to static method

        int num = 54321;
        System.out.println("Digits in " + num + " = " + dc.count(num));
    }
}
