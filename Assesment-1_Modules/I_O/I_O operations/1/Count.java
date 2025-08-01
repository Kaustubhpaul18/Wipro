import java.io.FileReader;
import java.util.Scanner;

public class Count {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file name");
        String fileName = sc.nextLine();

        System.out.println("Enter the character to be counted");
        char letter = sc.nextLine().charAt(0);
        letter = Character.toLowerCase(letter); 

        int count = 0;

        FileReader file = new FileReader(fileName);
        int ch;
        while ((ch = file.read()) != -1) {
            char current = Character.toLowerCase((char) ch); 
            if (current == letter) {
                count++;
            }
        }
        file.close();

        System.out.println("File '" + fileName + "' has " + count + " instances of letter '" + letter + "'.");
        sc.close();
    }
}
