class Color {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a color");
            return;
        }

        String color = args[0].toUpperCase(); // Convert input to uppercase
        switch (color) {
            case "R":
                System.out.println("Red");
                break;
            case "B":
                System.out.println("Blue");
                break;
            case "G":
                System.out.println("Green");
                break;
            case "O":
                System.out.println("Orange");
                break;
            case "Y":
                System.out.println("Yellow");
                break;
            case "W":
                System.out.println("White");
                break;
            default:
                System.out.println("Invalid Code");
        }
    }
}