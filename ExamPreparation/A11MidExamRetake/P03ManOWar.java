package ExamPreparation.A11MidExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class P03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays
                .stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] warship = Arrays
                .stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Retire")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    int damage = Integer.parseInt(input.split(" ")[2]);

                    if (isValidIndex(warship, index)) {
                        warship[index] -= damage;

                        if (warship[index] <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(input.split(" ")[1]);
                    int endIndex = Integer.parseInt(input.split(" ")[2]);
                    int damageOfWarship = Integer.parseInt(input.split(" ")[3]);

                    if (isValidIndex(pirateShip, startIndex) && isValidIndex(pirateShip, endIndex)) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip[i] -= damageOfWarship;

                            if (pirateShip[i] <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexToRepairAt = Integer.parseInt(input.split(" ")[1]);
                    int health = Integer.parseInt(input.split(" ")[2]);

                    if (isValidIndex(pirateShip, indexToRepairAt)) {
                        pirateShip[indexToRepairAt] += health;

                        if (pirateShip[indexToRepairAt] > maxHealthCapacity) {
                            pirateShip[indexToRepairAt] = maxHealthCapacity;
                        }
                    }
                    break;
                case "Status":
                    int needRepairCount = 0;
                    for (int section : pirateShip) {
                        if (section < 0.2 * maxHealthCapacity) {
                            needRepairCount++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", needRepairCount);
                    break;
            }

            input = scanner.nextLine();
        }

        int pirateShipSum = getShipStatus(pirateShip);
        int warshipSum = getShipStatus(warship);

        System.out.printf("Pirate ship status: %d%nWarship status: %d", pirateShipSum, warshipSum);
    }

    private static int getShipStatus(int[] numbers) {
        int sum = 0;
        for (int section : numbers) {
            sum += section;
        }
        return sum;
    }

    private static boolean isValidIndex(int[] numbers, int index) {
        return index >= 0 && index <= numbers.length - 1;
    }
}
