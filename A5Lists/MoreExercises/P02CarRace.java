package A5Lists.MoreExercises;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class P02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] leftRacer = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
        int[] rightRacer = Arrays.copyOfRange(numbers, numbers.length / 2 + 1, numbers.length);

        double leftRacerTime = getLeftRacerTime(leftRacer);
        double rightRacerTime = getRightRacerTime(rightRacer);

        DecimalFormat df = new DecimalFormat("####.0");
        if (leftRacerTime < rightRacerTime) {
            System.out.println("The winner is left with total time:" + " " + df.format(leftRacerTime));

        } else {
            System.out.println("The winner is right with total time:" + " " + df.format(rightRacerTime));
        }

    }

    private static double getLeftRacerTime(int[] racerTimes) {

        double timeOfLeftRacer = 0;

        for (int i = 0; i <= racerTimes.length - 1; i++) {
            if (racerTimes[i] != 0) {
                timeOfLeftRacer += racerTimes[i];
            } else {
                timeOfLeftRacer *= 0.8;
            }
        }
        return timeOfLeftRacer;
    }

    private static double getRightRacerTime(int[] racerTimes) {

        double timeOfRightRacer = 0;

        for (int i = racerTimes.length - 1; i >= 0; i--) {
            if (racerTimes[i] != 0) {
                timeOfRightRacer += racerTimes[i];
            } else {
                timeOfRightRacer *= 0.8;
            }
        }
        return timeOfRightRacer;
    }
}
