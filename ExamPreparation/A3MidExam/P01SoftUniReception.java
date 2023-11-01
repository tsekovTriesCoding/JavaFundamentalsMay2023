package ExamPreparation.A3MidExam;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int totalStudentsPerHour = firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;

        int hoursCount = 0;
        while (studentsCount > 0) {
            hoursCount++;
            if (hoursCount % 4 == 0) {
                hoursCount++;
            }
            studentsCount -= totalStudentsPerHour;
        }

        System.out.printf("Time needed: %dh.", hoursCount);
    }
}
