package A13ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class P05Students {

        static class Student {
        String firstName;
        String lastName;
        int age;
        String hometown;

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getHometown() {
            return this.hometown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public int getAge() {
            return this.age;
        }

        public String getLastName() {
            return this.lastName;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] inputParts = input.split(" ");

            String firstName = inputParts[0];
            String lastName = inputParts[1];
            int age = Integer.parseInt(inputParts[2]);
            String hometown = inputParts[3];

            Student student = new Student(firstName, lastName, age, hometown);

            studentsList.add(student);

            input = scanner.nextLine();
        }

        String town = scanner.nextLine();

        for (Student student : studentsList) {

            if (town.equals(student.getHometown())) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(),
                        student.getAge());
            }
        }
    }
}
