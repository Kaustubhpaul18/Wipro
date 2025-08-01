import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class reserve {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(
            "apple", "banana", "cherry", "date", "elderberry",
            "fig", "grape", "honeydew", "kiwi", "lemon"
        ));

        Consumer<ArrayList<String>> reverseWords = list -> {
            for (int i = 0; i < list.size(); i++) {
                String reversed = new StringBuilder(list.get(i)).reverse().toString();
                list.set(i, reversed);
            }
        };

        reverseWords.accept(words);

        System.out.println(words);
    }
}