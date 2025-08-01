import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetOperations {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Mango");
        treeSet.add("Grapes");

        // a) Reverse the elements of the Collection
        ArrayList<String> list = new ArrayList<>(treeSet);
        Collections.reverse(list);
        System.out.println("Reversed TreeSet:");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // b) Iterate the elements of the TreeSet using Iterator
        System.out.println("\nIterating TreeSet using Iterator:");
        Iterator<String> it = treeSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // c) Check if a particular element exists
        String checkItem = "Apple";
        if (treeSet.contains(checkItem)) {
            System.out.println("\n'" + checkItem + "' exists in the TreeSet.");
        } else {
            System.out.println("\n'" + checkItem + "' does not exist in the TreeSet.");
        }
    }
}
