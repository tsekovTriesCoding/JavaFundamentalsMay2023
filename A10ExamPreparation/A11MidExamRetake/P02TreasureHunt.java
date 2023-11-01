package A10ExamPreparation.A11MidExamRetake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialLoot = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] commandParts = command.split(" ");

            if (command.startsWith("Loot")) {
                for (int i = 1; i <= commandParts.length - 1; i++) {
                    if (!initialLoot.contains(commandParts[i])) {
                        initialLoot.add(0, commandParts[i]);
                    }
                }

            } else if (command.startsWith("Drop")) {
                int index = Integer.parseInt(commandParts[1]);

                if (index >= 0 && index <= initialLoot.size() - 1) {
                    String removedElement = initialLoot.get(index);
                    initialLoot.remove(index);
                    initialLoot.add(removedElement);
                }

            } else if (command.startsWith("Steal")) {

                int stealCount = Integer.parseInt(commandParts[1]);
                List<String> stolenLoot = new ArrayList<>();

                if (stealCount > initialLoot.size()) {
                    stealCount = initialLoot.size();
                }

                for (int i = 1; i <= stealCount; i++) {
                    String stolenItem = initialLoot.get(initialLoot.size() - 1);
                    initialLoot.remove(initialLoot.size() - 1);
                    stolenLoot.add(0, stolenItem);
                }
                System.out.println(String.join(", ", stolenLoot));
            }

            command = scanner.nextLine();
        }

        if (initialLoot.size() > 0) {
            int sumOfItemsLength = 0;

            for (int i = 0; i <= initialLoot.size() - 1; i++) {
                sumOfItemsLength += initialLoot.get(i).length();
            }
            double avgTreasureGain = sumOfItemsLength * 1.0 / initialLoot.size();

            System.out.printf("Average treasure gain: %.2f pirate credits.", avgTreasureGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
