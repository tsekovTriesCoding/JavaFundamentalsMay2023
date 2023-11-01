package A5Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if (command.contains("Delete")) {
                int elementToDelete = Integer.parseInt(command.split(" ")[1]);

                numbers.removeAll(Arrays.asList(elementToDelete));
            } else if (command.contains("Insert")) {
                int elementToInsert = Integer.parseInt(command.split(" ")[1]);
                int indexToInsertAt = Integer.parseInt(command.split(" ")[2]);

                numbers.add(indexToInsertAt, elementToInsert);
            }

            command = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
