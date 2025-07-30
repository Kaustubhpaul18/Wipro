import java.util.*;

public class OddLengthStringsLambda {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>(Arrays.asList(
            "Java", "Lambda", "Stream", "Odd", "Length", 
            "List", "Array", "Tree", "Map", "Code"
        ));

        System.out.println("Strings with odd length:");
        al.stream()
          .filter(s -> s.length() % 2 != 0)
          .forEach(System.out::println);
    }
}
