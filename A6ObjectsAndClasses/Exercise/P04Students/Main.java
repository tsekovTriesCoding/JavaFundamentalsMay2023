package A14ExerciseObjectsAndClasses.Exercise.P04Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> studentsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String firstName = input.split("\\s+")[0];
            String lastName = input.split("\\s+")[1];
            double grade = Double.parseDouble(input.split("\\s+")[2]);

            Student student = new Student(firstName, lastName, grade);

            studentsList.add(student);
        }

        studentsList.sort(Comparator.comparing(Student::getGrade).reversed());

        for (Student student : studentsList) {
            System.out.printf("%s %s: %.2f\n", student.getFirstName(), student.getLastName(), student.getGrade());
        }
    }
}
