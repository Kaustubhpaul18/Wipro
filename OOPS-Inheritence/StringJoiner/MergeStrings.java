import java.util.StringJoiner;

public class MergeStrings {
    public static void main(String[] args) {
        StringJoiner s1 = new StringJoiner("-", "[", "]");
        s1.add("Delhi").add("Mumbai");

        StringJoiner s2 = new StringJoiner("-", "(", ")");
        s2.add("Chennai").add("Kolkata");

        // Case 1: s1 merged into s2
        StringJoiner merged1 = new StringJoiner("-", "(", ")");
        merged1.merge(s1);
        merged1.merge(s2);
        System.out.println("s1 merged to s2: " + merged1);

        // Case 2: s2 merged into s1
        StringJoiner merged2 = new StringJoiner("-", "[", "]");
        merged2.merge(s2);
        merged2.merge(s1);
        System.out.println("s2 merged to s1: " + merged2);
    }
}
