package A10ExamPreparation.A3MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.startsWith("swap")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int element1 = numbers.get(index1);
                int element2 = numbers.get(index2);

                numbers.set(index1, element2);
                numbers.set(index2, element1);

            } else if (command.startsWith("multiply")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int newElement = numbers.get(index1) * numbers.get(index2);

                numbers.set(index1, newElement);
            } else if (command.startsWith("decrease")) {
                for (int i = 0; i <= numbers.size() - 1; i++) {
                    numbers.set(i, numbers.get(i) - 1);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
