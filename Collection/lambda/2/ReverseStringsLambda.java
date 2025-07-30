import java.util.*;

public class ReverseStringsLambda {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>(Arrays.asList(
            "Java", "Lambda", "Stream", "Code", "Logic", 
            "List", "Array", "Tree", "Map", "Graph"
        ));

        System.out.println("Strings in reverse order:");
        Collections.reverse(al);
        al.forEach(s -> System.out.println(s));
    }
}
