import java.util.Arrays;
public class Duplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5, 1};
        int[] result = removeDuplicates(arr);
        System.out.println("Array after removing duplicates: " + Arrays.toString(result));
    }

    public static int[] removeDuplicates(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n == 0) return arr;

        int[] temp = new int[n];
        int j = 0;
        temp[j++] = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                temp[j++] = arr[i];
            }
        }

        return Arrays.copyOf(temp, j);
    }
}