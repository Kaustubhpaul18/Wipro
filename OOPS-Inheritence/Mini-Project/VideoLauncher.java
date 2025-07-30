import java.util.Scanner;

// 1. Video Class
class Video {
    String videoName;
    boolean checkout;
    int rating;

    // Constructor
    public Video(String videoName) {
        this.videoName = videoName;
        this.checkout = false; // By default, video is not checked out
        this.rating = 0; // Default rating
    }

    // Member functions
    public String getName() {
        return videoName;
    }

    public void doCheckout() {
        this.checkout = true;
    }

    public void doReturn() {
        this.checkout = false;
    }

    public void receiveRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public boolean getCheckout() {
        return checkout;
    }
}

// 2. VideoStore Class
class VideoStore {
    Video[] store; // Array to store Video objects
    int videoCount; // To keep track of the number of videos in the store

    public VideoStore() {
        store = new Video[10]; // Initial capacity of 10 videos
        videoCount = 0;
    }

    public void addVideo(String name) {
        if (videoCount < store.length) {
            store[videoCount] = new Video(name);
            videoCount++;
            System.out.println("Video \"" + name + "\" added successfully.");
        } else {
            System.out.println("Video store is full. Cannot add more videos.");
            // In a real application, you might want to resize the array or use a List
        }
    }

    public void doCheckout(String name) {
        Video video = findVideo(name);
        if (video != null) {
            if (!video.getCheckout()) {
                video.doCheckout();
                System.out.println("Video \"" + name + "\" checked out successfully.");
            } else {
                System.out.println("Video \"" + name + "\" is already checked out.");
            }
        } else {
            System.out.println("Video \"" + name + "\" not found in the store.");
        }
    }

    public void doReturn(String name) {
        Video video = findVideo(name);
        if (video != null) {
            if (video.getCheckout()) {
                video.doReturn();
                System.out.println("Video \"" + name + "\" returned successfully.");
            } else {
                System.out.println("Video \"" + name + "\" is not currently checked out.");
            }
        } else {
            System.out.println("Video \"" + name + "\" not found in the store.");
        }
    }

    public void receiveRating(String name, int rating) {
        Video video = findVideo(name);
        if (video != null) {
            if (rating >= 1 && rating <= 10) {
                video.receiveRating(rating);
                System.out.println("Rating \"" + rating + "\" has been mapped to the Video \"" + name + "\".");
            } else {
                System.out.println("Invalid rating. Please provide a rating between 1 and 10.");
            }
        } else {
            System.out.println("Video \"" + name + "\" not found in the store.");
        }
    }

    public void listInventory() {
        if (videoCount == 0) {
            System.out.println("The video store is empty.");
            return;
        }
        System.out.println("Video Name\t| Checkout Status | Rating");
        System.out.println("----------------------------------------");
        for (int i = 0; i < videoCount; i++) {
            System.out.printf("%-15s | %-15s | %d%n",
                              store[i].getName(),
                              store[i].getCheckout() ? "true" : "false",
                              store[i].getRating());
        }
    }

    // Helper method to find a video by name
    private Video findVideo(String name) {
        for (int i = 0; i < videoCount; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                return store[i];
            }
        }
        return null; // Video not found
    }
}

// 3. VideoLauncher Class
public class VideoLauncher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoStore videoStore = new VideoStore();
        int choice;

        do {
            System.out.println("\nMAIN MENU");
            System.out.println("==========");
            System.out.println("1. Add Videos:");
            System.out.println("2. Check Out Video:");
            System.out.println("3. Return Video:");
            System.out.println("4. Receive Rating:");
            System.out.println("5. List Inventory:");
            System.out.println("6. Exit:");
            System.out.print("Enter your choice (1..6): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the video you want to add: ");
                    String addVideoName = scanner.nextLine();
                    videoStore.addVideo(addVideoName);
                    break;
                case 2:
                    System.out.print("Enter the name of the video you want to check out: ");
                    String checkoutVideoName = scanner.nextLine();
                    videoStore.doCheckout(checkoutVideoName);
                    break;
                case 3:
                    System.out.print("Enter the name of the video you want to Return: ");
                    String returnVideoName = scanner.nextLine();
                    videoStore.doReturn(returnVideoName);
                    break;
                case 4:
                    System.out.print("Enter the name of the video you want to Rate: ");
                    String rateVideoName = scanner.nextLine();
                    System.out.print("Enter the rating for this video: ");
                    int rating = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    videoStore.receiveRating(rateVideoName, rating);
                    break;
                case 5:
                    videoStore.listInventory();
                    break;
                case 6:
                    System.out.println("Exiting...!! Thanks for using the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}