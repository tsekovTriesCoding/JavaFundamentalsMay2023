package A10ExamPreparation.A9MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {

            String item = input.split(" - ")[1];
            if (input.startsWith("Collect")) {

                if (!items.contains(item)) {
                    items.add(item);
                }
            } else if (input.startsWith("Drop")) {
                items.remove(item);
            } else if (input.startsWith("Combine")) {
                String oldItem = input.split(" - ")[1].split(":")[0];
                String newItem = input.split(" - ")[1].split(":")[1];

                if (items.contains(oldItem)) {
                    items.add(items.indexOf(oldItem) + 1, newItem);
                }
            } else if (input.startsWith("Renew")) {
                if (items.contains(item)) {
                    items.remove(item);
                    items.add(item);
                }
            }

            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", items));
    }
}
