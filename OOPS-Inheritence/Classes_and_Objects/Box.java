// Box.java
public class Box {
    private final double width;
    private double height, depth;

    // Parameterized constructor
    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // Method to calculate volume
    public double getVolume() {
        return width * height * depth;
    }

    // Main method to test functionality
    public static void main(String[] args) {
        Box myBox = new Box(5.0, 4.0, 3.0);
        System.out.println("Volume of the box is: " + myBox.getVolume());
    }
}
