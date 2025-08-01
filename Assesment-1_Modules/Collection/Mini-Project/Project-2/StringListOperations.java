import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringListOperations {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1: // Insert
                    System.out.print("Enter the item to be inserted: ");
                    String itemToInsert = scanner.nextLine();
                    stringList.add(itemToInsert);
                    System.out.println("Inserted successfully");
                    break;
                case 2: // Search
                    System.out.print("Enter the item to be searched: ");
                    String itemToSearch = scanner.nextLine();
                    if (stringList.contains(itemToSearch)) {
                        System.out.println("Item found in the list.");
                    } else {
                        System.out.println("Item not found in the list.");
                    }
                    break;
                case 3: // Delete
                    System.out.print("Enter the item to be deleted: ");
                    String itemToDelete = scanner.nextLine();
                    if (stringList.remove(itemToDelete)) {
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println("Item not found in the list.");
                    }
                    break;
                case 4: // Display
                    if (stringList.isEmpty()) {
                        System.out.println("List is empty.");
                    } else {
                        System.out.println("Items in the list:");
                        for (int i = 0; i < stringList.size(); i++) {
                            System.out.println((i + 1) + ". " + stringList.get(i));
                        }
                    }
                    break;
                case 5: // Exit
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
            System.out.println(); // Add a newline for better readability between operations

        } while (choice != 5);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. Insert");
        System.out.println("2. Search");
        System.out.println("3. Delete");
        System.out.println("4. Display");
        System.out.println("5. Exit");
    }
}