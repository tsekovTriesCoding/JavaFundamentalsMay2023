package ExamPreparation.A7MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] inputParts = (input.split(" "));
            String command = inputParts[0];

            switch (command) {
                case "Urgent":
                    String itemToAdd = inputParts[1];

                    if (!products.contains(itemToAdd)) {
                        products.add(0, itemToAdd);
                    }
                    break;
                case "Unnecessary":
                    String itemToRemove = inputParts[1];
                    products.remove(itemToRemove);
                    break;
                case "Correct":
                    String oldItem = inputParts[1];
                    String newItem = inputParts[2];

                    if (products.contains(oldItem)) {
                        products.set(products.indexOf(oldItem), newItem);
                    }
                    break;
                case "Rearrange":
                    String itemToRearrange = inputParts[1];

                    if (products.contains(itemToRearrange)) {
                        products.remove(itemToRearrange);
                        products.add(itemToRearrange);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", products));
    }
}
