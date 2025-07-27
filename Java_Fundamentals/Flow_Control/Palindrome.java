public class Palindrome {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a number as a command line argument.");
            return;
        }
        String input = args[0];
        // Check if input is a valid integer (only digits, optional leading minus)
        if (!input.matches("-?\\d+")) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }
        int number = Integer.parseInt(input);
        int original = number;
        int reversed = 0;
        int temp = Math.abs(number);
        while (temp > 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        if (Math.abs(original) == reversed) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }
    }
}