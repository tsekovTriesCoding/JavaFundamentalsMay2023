package A5Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.contains("Contains")) {
                int numberToCheck = Integer.parseInt(command.split(" ")[1]);

                if (numbers.contains(numberToCheck)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }

            } else if (command.contains("Print even")) {
                printEven(numbers);

            } else if (command.contains("Print odd")) {
                printOdd(numbers);

            } else if (command.contains("Get sum")) {
                printSum(numbers);
            } else if (command.contains("Filter")) {
                String condition = (command.split(" ")[1]);
                int numberToCompareTo = Integer.parseInt(command.split(" ")[2]);

                printFilteredNumbers(numbers, condition, numberToCompareTo);
            }
            command = scanner.nextLine();
        }
    }

    private static void printFilteredNumbers(List<Integer> numbers, String condition, int numberToCompareTo) {

        String result = "";
        if (condition.equals("<")) {
            for (int number : numbers) {
                if (number < numberToCompareTo) {
                    result += number + " ";
                }
            }
        } else if (condition.equals(">")) {
            for (int number : numbers) {
                if (number > numberToCompareTo) {
                    result += number + " ";
                }
            }
        } else if (condition.equals(">=")) {
            for (int number : numbers) {
                if (number >= numberToCompareTo) {
                    result += number + " ";
                }
            }
        } else if (condition.equals("<=")) {
            for (int number : numbers) {
                if (number <= numberToCompareTo) {
                    result += number + " ";
                }
            }
        }

        System.out.println(result);
    }

    private static void printSum(List<Integer> numbers) {

        int sumOfNumbers = 0;
        for (int number : numbers) {
            sumOfNumbers += number;
        }
        System.out.println(sumOfNumbers);
    }

    private static void printOdd(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static void printEven(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}
