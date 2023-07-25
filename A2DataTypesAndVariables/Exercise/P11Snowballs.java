package A4ExerciseDataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snowballsMade = Integer.parseInt(scanner.nextLine());

        double highestValue = Double.MIN_VALUE;
        int bestSnow = Integer.MIN_VALUE;
        int bestTime = Integer.MIN_VALUE;
        int bestQuality = Integer.MIN_VALUE;

        for (int i = 1; i <= snowballsMade; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow(((double) snowballSnow / snowballTime), snowballQuality);

            if (snowballValue >= highestValue) {
                highestValue = snowballValue;
                bestSnow = snowballSnow;
                bestTime = snowballTime;
                bestQuality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", bestSnow, bestTime, highestValue, bestQuality);
    }
}
