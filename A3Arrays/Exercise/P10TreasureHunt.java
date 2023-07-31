package A6ExerciseArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P10TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] loot = scanner.nextLine().split("\\|");
        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] commandParts = command.split(" ");
            String commandType = commandParts[0];

            switch (commandType) {
                case "Loot":
                    List<String> lootList = new ArrayList<String>(Arrays.asList(loot));
                    for (int i = 1; i <= commandParts.length - 1; i++) {
                        if (!lootList.contains(commandParts[i])) {
                            lootList.add(0, commandParts[i]);
                        }
                    }
                    loot = lootList.toArray(loot);
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(commandParts[1]);
                    if (dropIndex >= 0 && dropIndex <= loot.length - 1) {
                        String dropElement = loot[dropIndex];

                        for (int leftIndex = dropIndex; leftIndex < loot.length - 1; leftIndex++) {
                            loot[leftIndex] = loot[leftIndex + 1];
                        }

                        loot[loot.length - 1] = dropElement;
                    } else {
                        break;
                    }
                    break;
                case "Steal":
                    int stealCount = Integer.parseInt(commandParts[1]);


                    if (stealCount <= loot.length) {
                        String[] stolenLoot = Arrays.copyOfRange(loot, loot.length - stealCount, loot.length);
                        loot = Arrays.copyOf(loot, loot.length - stealCount);
                        System.out.println(String.join(", ", stolenLoot));
                    } else {
                        String[] stolenLoot = Arrays.copyOfRange(loot, 0, loot.length);
                        loot = Arrays.copyOf(loot, 0);
                        System.out.println(String.join(", ", stolenLoot));
                    }

                    break;
            }
            command = scanner.nextLine();
        }

        if (loot.length > 0) {
            int treasureItemsLengthSum = 0;
            for (int i = 0; i <= loot.length - 1; i++) {
                treasureItemsLengthSum += loot[i].length();
            }
            double averageTreasureGain = treasureItemsLengthSum * 1.0 / loot.length;

            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}

