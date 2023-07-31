package A6ExerciseArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int index = 0; index <= numbers.length - 1; index++) {
            int topInteger = numbers[index];
            boolean isBigger = true;
            for (int j = index + 1; j <= numbers.length - 1; j++) {

                if (numbers[index] <= numbers[j]) {
                    isBigger = false;
                    break;

                }
            }
            if (isBigger) {
                System.out.print(topInteger + " ");
            }
        }

    }
}
