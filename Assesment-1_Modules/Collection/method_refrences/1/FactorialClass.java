@FunctionalInterface
interface Factorial {
    int compute(int n);
}

class FactorialClass {
    public int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        FactorialClass obj = new FactorialClass();
        Factorial f = obj::factorial;  // method reference to instance method

        int result = f.compute(5);
        System.out.println("Factorial of 5 = " + result);
    }
}
