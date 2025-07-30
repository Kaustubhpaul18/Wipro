import java.util.ArrayList;

public class Dtype {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(15.5);
        numbers.add(3.14f);
        numbers.add(100L);

        for (Number n : numbers) {
            System.out.println(n);
        }
    }
}
