class Range {
    public static void main(String[] args) {
        for (int num = 10; num <= 99; num++) {
            int i;
            for (i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                break;
            }
            }
            if (i > Math.sqrt(num)) {
            System.out.print(num + " ");
            }
        }
    }
}