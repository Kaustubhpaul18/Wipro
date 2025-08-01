class Number{
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a number ");
            return;
        }
        int number = Integer.parseInt(args[0]);
        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }
    }
}