package A4ExerciseDataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startSourceYield = Integer.parseInt(scanner.nextLine());
        int crewPart = 26;
        int totalspiceGathered = 0;
        int days = 0;

        while (startSourceYield >= 100) {
            days++;
            int spicePerDay = startSourceYield;
            if (crewPart <= spicePerDay) {
                spicePerDay -= crewPart;
            }

            totalspiceGathered += spicePerDay;
            startSourceYield -= 10;
        }

        if (crewPart <= totalspiceGathered) {
            totalspiceGathered -= crewPart;
        }

        System.out.println(days);
        System.out.println(totalspiceGathered);
    }
}
