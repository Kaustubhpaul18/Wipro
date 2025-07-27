class Prime{
    public static void main(String[] args){
        if (args.length < 1){
            System.out.println("Enter a Number");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int count = 0;
        if (n <= 1) {
            System.out.println(n + " is not a prime number");
        } else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println(n + " is a prime number");
            } else {
                System.out.println(n + " is not a prime number");
            }
        }
    }
}