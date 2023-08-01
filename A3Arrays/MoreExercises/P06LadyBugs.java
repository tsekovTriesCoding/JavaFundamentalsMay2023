package A6ExerciseArrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06LadyBugs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] initialIndexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        int[] field = new int[n];

        for (int initialIndex : initialIndexes) {
            if (initialIndex >= 0 && initialIndex < field.length) {
                field[initialIndex] = 1;
            }
        }

        while (!input.equals("end")) {
            int index = Integer.parseInt(input.split("\\s+")[0]);
            String direction = input.split("\\s+")[1];
            int flyLength = Integer.parseInt(input.split("\\s+")[2]);

            if (index >= 0 && index <= field.length - 1 && field[index] == 1) {
                field[index] = 0;

                switch (direction) {
                    case "right":
                        index += flyLength;

                        while (index <= field.length - 1 && field[index] == 1) {
                            index += flyLength;
                        }

                        if (index <= field.length - 1) {
                            field[index] = 1;
                        }
                        break;
                    case "left":
                        index -= flyLength;

                        while (index >= 0 && field[index] == 1) {
                            index -= flyLength;
                        }

                        if (index >= 0) {
                            field[index] = 1;
                        }

                        break;
                }
            }

            input = scanner.nextLine();
        }

        for (
                int i : field) {
            System.out.print(i + " ");
        }
    }
}
