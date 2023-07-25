package A4ExerciseDataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class P03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        double eps = 0.000001;
        double diff = Math.abs(a - b);

        if (diff >= eps) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }


    }
}
