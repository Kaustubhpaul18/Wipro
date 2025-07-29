public class MiddleWay {
    public static int[] middleWay(int[] a, int[] b) {
        // Both arrays are length 3, so middle element is at index 1
        return new int[]{a[1], b[1]};
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] result1 = middleWay(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        int[] result2 = middleWay(new int[]{7, 7, 7}, new int[]{3, 8, 0});
        int[] result3 = middleWay(new int[]{5, 2, 9}, new int[]{1, 4, 5});

        printArray(result1); 
        printArray(result2); 
        printArray(result3); 
    }
}
