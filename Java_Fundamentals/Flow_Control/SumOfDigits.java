public class SumOfDigits {
    public static void main(String[] args) {
        int sum = 0;
        int num = 15487;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        System.out.println("The sum of the digits is: " + sum);
    }
}