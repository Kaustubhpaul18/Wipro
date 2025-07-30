import java.util.Random;

abstract class Compartment {
    public abstract String notice();
}

class FirstClass extends Compartment {
    public String notice() {
        return "This is a First Class compartment.";
    }
}

class Ladies extends Compartment {
    public String notice() {
        return "This is a Ladies compartment.";
    }
}

class General extends Compartment {
    public String notice() {
        return "This is a General compartment.";
    }
}

class Luggage extends Compartment {
    public String notice() {
        return "This is a Luggage compartment.";
    }
}

public class TestCompartment {
    public static void main(String[] args) {
        Compartment[] compartments = new Compartment[10];
        Random random = new Random();

        for (int i = 0; i < compartments.length; i++) {
            int type = random.nextInt(4) + 1;  // 1 to 4
            switch (type) {
                case 1: compartments[i] = new FirstClass(); break;
                case 2: compartments[i] = new Ladies(); break;
                case 3: compartments[i] = new General(); break;
                case 4: compartments[i] = new Luggage(); break;
            }
        }

        for (Compartment compartment : compartments) {
            System.out.println(compartment.notice());
        }
    }
}
