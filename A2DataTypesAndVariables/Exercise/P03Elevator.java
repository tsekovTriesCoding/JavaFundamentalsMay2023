package A2DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        //int fullCourses = numberOfPeople / elevatorCapacity;
        //if (numberOfPeople % elevatorCapacity != 0) {
        //   fullCourses++;
        //   }

        int courses = (int) Math.ceil((double) numberOfPeople / elevatorCapacity);
        System.out.println(courses);
    }
}
