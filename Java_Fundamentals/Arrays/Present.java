import java.util.Scanner;
public class Present {
    public static void main(String[] args) {
        int[] arr = {10, 25, 30, 45, 50, 60};
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter a number to search: ");
            int num = sc.nextInt();

            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == num) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("-1");
            } else {
                System.out.println("Number found at index: " + index);
            }
        }
    }
}