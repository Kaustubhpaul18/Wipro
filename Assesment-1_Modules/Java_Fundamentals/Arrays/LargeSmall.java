public class LargeSmall {
    public static void main(String[] args) {
        int[] arr = {12, 45, 2, 41, 31, 10, 99, 23};

        if (arr.length < 2) {
            System.out.println("Array must have at least 2 elements.");
            return;
        }

        int firstLargest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        int firstSmallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
           
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num != firstLargest) {
                secondLargest = num;
            }

            
            if (num < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = num;
            } else if (num < secondSmallest && num != firstSmallest) {
                secondSmallest = num;
            }
        }

        System.out.println("Largest two numbers: " + firstLargest + ", " + secondLargest);
        System.out.println("Smallest two numbers: " + firstSmallest + ", " + secondSmallest);
    }
}