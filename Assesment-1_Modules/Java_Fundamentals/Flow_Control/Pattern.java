public class Pattern {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide number of rows as a command line argument.");
            return;
        }

        int rows = Integer.parseInt(args[0]);

        // Using for loop
        System.out.println("Floyd's Triangle using for loop:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Using while loop
        System.out.println("\nFloyd's Triangle using while loop:");
        int i = 1;
        while (i <= rows) {
            int j = 1;
            while (j <= i) {
                System.out.print("* ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}