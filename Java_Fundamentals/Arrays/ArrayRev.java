public class ArrayRev {
    public static void main(String[] args) {
        // Check for exactly 4 arguments
        if (args.length != 4) {
            System.out.println("Please enter 4 integer numbers");
            return;
        }

        int[][] array = new int[2][2];
        int k = 0;

        // Fill the 2x2 array from args
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(args[k++]);
            }
        }

        // Print the original array
        System.out.println("The given array is :");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // Print the reversed array
        System.out.println("The reverse of the array is :");
        for (int i = 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
