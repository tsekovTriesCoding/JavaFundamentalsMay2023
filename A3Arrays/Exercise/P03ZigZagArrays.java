package A6ExerciseArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers1 = new int[n];
        int[] numbers2 = new int[n];

        for (int i = 0; i < n; i++) {
            int[] currentNumbers = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (i % 2 == 0) {
                numbers1[i] = currentNumbers[0];
                numbers2[i] = currentNumbers[1];
            } else {
                numbers1[i] = currentNumbers[1];
                numbers2[i] = currentNumbers[0];
            }
        }
        for (int i = 0; i <= numbers1.length - 1; i++) {
            System.out.print(numbers1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <= numbers2.length - 1; i++) {
            System.out.print(numbers2[i] + " ");
        }
    }
}
