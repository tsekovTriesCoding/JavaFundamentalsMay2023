package A6ExerciseArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfRotations = Integer.parseInt(scanner.nextLine());

        int firstElement = 0;

        for (int i = 1; i <= numberOfRotations; i++) {
            firstElement = numbers[0];
            for (int index = 0; index < numbers.length - 1; index++) {
                numbers[index] = numbers[index + 1];
            }
            numbers[numbers.length - 1] = firstElement;

        }
        for (int element : numbers) {
            System.out.print(element + " ");
        }

    }
}
