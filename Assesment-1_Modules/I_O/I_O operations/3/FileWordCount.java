import java.io.*;
import java.util.*;

public class FileWordCount {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: java FileWordCount inputFile.txt outputFile.txt");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        // Map to store word counts (TreeMap to keep words sorted)
        Map<String, Integer> wordCount = new TreeMap<>();

        // Read from input file using try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split by space
                for (String word : words) {
                    // Optional: remove punctuation and convert to lowercase if needed
                    word = word.trim();
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        // Write to output file using try-with-resources
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String word : wordCount.keySet()) {
                writer.write(word + " : " + wordCount.get(word));
                writer.newLine();
            }
        }

        System.out.println("Word count written to " + outputFile);
    }
}
