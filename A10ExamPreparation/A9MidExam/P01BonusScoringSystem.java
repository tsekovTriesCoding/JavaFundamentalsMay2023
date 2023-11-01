package A10ExamPreparation.A9MidExam;

import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int numberOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double totalBonus = 0;
        double maxBonus = Double.MIN_VALUE;
        int attendanceOfStudentWithMaxBonus = 0;
        for (int i = 1; i <= numberOfStudents; i++) {
            int attendanceOfEachStudent = Integer.parseInt(scanner.nextLine());

            totalBonus = attendanceOfEachStudent * 1.0 / numberOfLectures * (5 + additionalBonus);

            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                attendanceOfStudentWithMaxBonus = attendanceOfEachStudent;
            }
        }

        maxBonus = Math.round(maxBonus);
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", attendanceOfStudentWithMaxBonus);
    }
}
