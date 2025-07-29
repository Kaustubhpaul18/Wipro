public class Sort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7, 3};
        System.out.println("Original array:");
        for(int n : arr){
            System.out.print(n + " ");
        }
        java.util.Arrays.sort(arr);

        System.out.println("\nSorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}