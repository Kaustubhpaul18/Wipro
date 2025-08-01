// Calculator.java
public class Calculator {

    // Method to calculate power for integers
    public static int powerInt(int num1, int num2) {
        return (int) Math.pow(num1, num2);
    }

    // Method to calculate power for double and integer
    public static double powerDouble(double num1, int num2) {
        return Math.pow(num1, num2);
    }

    // Main method to test both power methods
    public static void main(String[] args) {
        int result1 = Calculator.powerInt(2, 3);          // 2^3 = 8
        double result2 = Calculator.powerDouble(2.5, 3);  // 2.5^3 = 15.625

        System.out.println("powerInt(2, 3) = " + result1);
        System.out.println("powerDouble(2.5, 3) = " + result2);
    }
}
