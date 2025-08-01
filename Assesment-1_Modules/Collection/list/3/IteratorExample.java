import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    private final ArrayList<String> list;

    public IteratorExample() {
        list = new ArrayList<>();
    }

    public void add(String s) {
        list.add(s);
    }

    public void printAll() {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        IteratorExample example = new IteratorExample();
        example.add("Apple");
        example.add("Banana");
        example.add("Cherry");
        example.printAll();
    }
}