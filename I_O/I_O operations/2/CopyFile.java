import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the input file name");
        String inputFile = sc.nextLine();


        System.out.println("Enter the output file name");
        String outputFile = sc.nextLine();


        FileReader in = new FileReader(inputFile);
        FileWriter out = new FileWriter(outputFile);

        int ch;

        while ((ch = in.read()) != -1) {
            out.write(ch);
        }

        in.close();
        out.close();
        
        System.out.println("File is copied.");
        sc.close();
    }
}
