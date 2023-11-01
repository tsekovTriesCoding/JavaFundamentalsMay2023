package A5Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            if (command.contains("Add")) {
                int numberToAdd = Integer.parseInt(command.split(" ")[1]);

                numbers.add(numberToAdd);

            } else if (command.contains("Insert")) {
                int numberToInsert = Integer.parseInt(command.split(" ")[1]);
                int indexToInsertAt = Integer.parseInt(command.split(" ")[2]);

                if (indexToInsertAt >= 0 && indexToInsertAt <= numbers.size() - 1) {
                    numbers.add(indexToInsertAt, numberToInsert);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Remove")) {
                int indexToRemove = Integer.parseInt(command.split(" ")[1]);

                if (indexToRemove >= 0 && indexToRemove <= numbers.size() - 1) {
                    numbers.remove(indexToRemove);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Shift left")) {
                int count = Integer.parseInt(command.split(" ")[2]);

                for (int i = 1; i <= count; i++) {
                    int firstNumber = numbers.get(0);

                    numbers.remove(0);
                    numbers.add(firstNumber);
                }
            } else if (command.contains("Shift right")) {
                int count = Integer.parseInt(command.split(" ")[2]);

                for (int i = 1; i <= count; i++) {
                    int lastNumber = numbers.get(numbers.size() - 1);

                    numbers.remove(numbers.size() - 1);
                    numbers.add(0, lastNumber);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
