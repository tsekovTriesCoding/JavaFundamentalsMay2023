package A10List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.contains("Add")) {
                int numberToAdd = Integer.parseInt(command.split(" ")[1]);
                numbers.add(numberToAdd);

            } else if (command.startsWith("RemoveAt")) {
                int indexOfNumberToRemove = Integer.parseInt(command.split(" ")[1]);
                numbers.remove(indexOfNumberToRemove);

            } else if (command.startsWith("Remove")) {
                int numberToRemove = Integer.parseInt(command.split(" ")[1]);
                numbers.remove(Integer.valueOf(numberToRemove));

            } else if (command.contains("Insert")) {
                int numberToAdd = Integer.parseInt(command.split(" ")[1]);
                int indexToAddAt = Integer.parseInt(command.split(" ")[2]);

                numbers.add(indexToAddAt, numberToAdd);
            }

            command = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
