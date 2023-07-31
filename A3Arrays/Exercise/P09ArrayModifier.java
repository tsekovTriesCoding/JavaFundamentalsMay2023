package A6ExerciseArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandParts = command.split(" ");
            String commandType = commandParts[0];

            switch (commandType) {
                case "swap":
                    int swapIndex1 = Integer.parseInt(commandParts[1]);
                    int swapElement1 = numbers[swapIndex1];
                    int swapIndex2 = Integer.parseInt(commandParts[2]);
                    int swapElement2 = numbers[swapIndex2];

                    numbers[swapIndex1] = swapElement2;
                    numbers[swapIndex2] = swapElement1;
                    break;
                case "multiply":
                    int multiplyIndex1 = Integer.parseInt(commandParts[1]);
                    int multiplyElement1 = numbers[multiplyIndex1];
                    int multiplyIndex2 = Integer.parseInt(commandParts[2]);
                    int multiplyElement2 = numbers[multiplyIndex2];

                    int newElement = multiplyElement1 * multiplyElement2;
                    numbers[multiplyIndex1] = newElement;
                    break;
                case "decrease":
                    for (int index = 0; index <= numbers.length - 1; index++) {
                        numbers[index] = numbers[index] - 1;
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (int index = 0; index <= numbers.length - 1; index++) {
            if (index != numbers.length - 1) {
                System.out.print(numbers[index] + ", ");
            } else {
                System.out.print(numbers[index]);
            }
        }
    }
}
