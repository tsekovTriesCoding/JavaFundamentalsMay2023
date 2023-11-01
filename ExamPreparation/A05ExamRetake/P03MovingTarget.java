package ExamPreparation.A05ExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] inputParts = input.split(" ");
            String command = inputParts[0];
            int index = Integer.parseInt(inputParts[1]);

            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(inputParts[2]);

                    if (isValidIndex(index, targets)) {
                        targets.set(index, targets.get(index) - power);

                        if (targets.get(index) <= 0) {
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(inputParts[2]);

                    if (isValidIndex(index, targets)) {
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(inputParts[2]);

                    if (index >= 0 && index - radius >= 0 && index + radius <= targets.size() - 1) {
                        for (int i = index + radius; i >= index - radius; i--) {
                            targets.remove(i);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(targets.toString().replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "|"));
    }

    public static boolean isValidIndex(int index, List<Integer> numbers) {

        return index >= 0 && index <= numbers.size() - 1;
    }
}
