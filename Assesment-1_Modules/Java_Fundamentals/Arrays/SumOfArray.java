public class SumOfArray {
    public static void main(String[] args) {
        int[] arr1 = {10, 3, 6, 1, 2, 7, 9};
        int[] arr2 = {7, 1, 2, 3, 6};
        int[] arr3 = {1, 6, 4, 7, 9};

        System.out.println("Output 1: " + sumArray(arr1)); // 22
        System.out.println("Output 2: " + sumArray(arr2)); // 19
        System.out.println("Output 3: " + sumArray(arr3)); // 10
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        boolean skip = false;

        for (int num : arr) {
            if (num == 6) {
                skip = true;
            } else if (skip && num == 7) {
                skip = false;
            } else if (!skip) {
                sum += num;
            }
        }

        return sum;
    }
}
