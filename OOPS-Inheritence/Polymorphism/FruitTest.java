// Base class
class Fruit {
    String name;
    String taste;
    int size;

    public Fruit(String name, String taste, int size) {
        this.name = name;
        this.taste = taste;
        this.size = size;
    }

    public void eat() {
        System.out.println("Eating " + name + " which tastes " + taste);
    }
}

// Subclass: Apple
class Apple extends Fruit {
    public Apple(int size) {
        super("Apple", "Sweet", size);
    }

    @Override
    public void eat() {
        System.out.println("Eating an Apple: Sweet and crunchy!");
    }
}

// Subclass: Orange
class Orange extends Fruit {
    public Orange(int size) {
        super("Orange", "Tangy", size);
    }

    @Override
    public void eat() {
        System.out.println("Eating an Orange: Tangy and juicy!");
    }
}

// Main class
public class FruitTest {
    public static void main(String[] args) {
        Fruit f1 = new Apple(5);
        Fruit f2 = new Orange(6);

        f1.eat();
        f2.eat();
    }
}
