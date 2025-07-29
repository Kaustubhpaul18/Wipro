import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer between 1 and 255: ");
        int number = scanner.nextInt();

        if (number < 1 || number > 255) {
            System.out.println("Invalid input. Please enter a number between 1 and 255.");
            return;
        }

        String binaryString = Integer.toBinaryString(number);
        String formattedBinary = String.format("%8s", binaryString).replace(' ', '0');
        System.out.println("Binary representation: " + formattedBinary);
    }
}
