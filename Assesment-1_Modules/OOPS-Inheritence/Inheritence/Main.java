class Animal {
    public void eat() {
        System.out.println("Animal is eating.");
    }

    public void sleep() {
        System.out.println("Animal is sleeping.");
    }
}

class Bird extends Animal {
    @Override
    public void eat() {
        System.out.println("Bird is pecking at food.");
    }

    @Override
    public void sleep() {
        System.out.println("Bird is sleeping in its nest.");
    }

    public void fly() {
        System.out.println("Bird is flying in the sky.");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        // Create and use Animal object
        Animal animal = new Animal();
        System.out.println("Animal Actions:");
        animal.eat();
        animal.sleep();

        // Create and use Bird object
        Bird bird = new Bird();
        System.out.println("\nBird Actions:");
        bird.eat();   // overridden method
        bird.sleep(); // overridden method
        bird.fly();   // new method
    }
}
