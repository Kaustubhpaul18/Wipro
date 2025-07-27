class Strings {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide two strings as command line arguments.");
            return;
        }
        String a = args[0];
        String b = args[1];
        System.out.println(a + " Technologies " + b);
    }
}