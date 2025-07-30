public class Employee {
    int empNo;
    String name;
    int age;
    String location;

    public Employee(int empNo, String name, int age, String location) {
        this.empNo = empNo;
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public void printDetails() {
        System.out.println(empNo + " " + name + " " + age + " " + location);
    }
}
