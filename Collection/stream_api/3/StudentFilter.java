import java.util.ArrayList;
public class StudentFilter {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 45));
        students.add(new Student(2, "Bob", 78));
        students.add(new Student(3, "Charlie", 52));
        students.add(new Student(4, "David", 49));
        students.add(new Student(5, "Eve", 90));

        int passedCount = 0;

        System.out.println("Students who passed:");
        for (Student s : students) {
            if (s.mark >= 50) {
                passedCount++;
                System.out.println(s.rollNo + " " + s.name + " " + s.mark);
            }
        }

        System.out.println("Total passed: " + passedCount);
    }
}