class Employee implements Cloneable {
    String name;
    int age;
    String department;

    Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Department: " + department);
    }

    public static void main(String[] args) {
        try {
            Employee original = new Employee("Raj", 30, "HR");
            Employee clone = (Employee) original.clone();

            // Modify original object
            original.name = "Kaustubh";
            original.age = 21;

            System.out.println("Original Employee:");
            original.display();

            System.out.println("Cloned Employee:");
            clone.display();

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported.");
        }
    }
}
