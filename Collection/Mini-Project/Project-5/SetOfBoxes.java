import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

// Box Class
class Box {
    private double length;
    private double width;
    private double height;
    private double volume; // Storing volume to avoid recalculation in equals/hashCode

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = length * width * height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return volume;
    }

    // Override equals method to compare based on volume
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        // Compare volumes. Using a small epsilon for double comparison due to precision issues
        return Math.abs(this.volume - box.volume) < 0.0001; // Example epsilon
    }

    // Override hashCode method consistent with equals
    @Override
    public int hashCode() {
        // Hashing based on volume.
        // It's crucial for objects that are equal to have the same hash code.
        // Convert double to long bits for hashing consistency.
        return Objects.hash(Double.doubleToLongBits(volume));
    }

    @Override
    public String toString() {
        return "Box [Length=" + length + ", Width=" + width + ", Height=" + height + ", Volume=" + String.format("%.2f", volume) + "]";
    }
}

public class SetOfBoxes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Using HashSet to store unique Box objects based on their overridden equals and hashCode methods
        Set<Box> boxSet = new HashSet<>();

        System.out.print("Enter the number of Box: ");
        int numberOfBoxes = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int i = 1; i <= numberOfBoxes; i++) {
            System.out.println("Enter the Box " + i + " details");
            System.out.print("Enter Length: ");
            double length = scanner.nextDouble();
            System.out.print("Enter Width: ");
            double width = scanner.nextDouble();
            System.out.print("Enter Height: ");
            double height = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline

            Box newBox = new Box(length, width, height);

            // Attempt to add the new box to the set.
            // If a box with the same volume already exists (due to equals() override), it won't be added.
            if (boxSet.add(newBox)) {
                System.out.println("Box with volume " + String.format("%.2f", newBox.getVolume()) + " inserted successfully.");
            } else {
                System.out.println("Volume already exists. Box with volume " + String.format("%.2f", newBox.getVolume()) + " not inserted.");
            }
        }

        System.out.println("\nBoxes in the Set (Unique Volumes):");
        if (boxSet.isEmpty()) {
            System.out.println("No boxes in the set.");
        } else {
            for (Box box : boxSet) {
                System.out.println(box);
            }
        }

        scanner.close();
    }
}