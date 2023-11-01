package ExamPreparation.A9MidExam;

import java.util.Scanner;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|");

        int health = 100;
        int roomCount = 0;
        int totalBitcoins = 0;

        for (String room : rooms) {
            String command = room.split(" ")[0];
            int amount = Integer.parseInt(room.split(" ")[1]);
            roomCount++;

            if (command.equals("potion")) {

                int amountHealed = 0;
                if (health < 100) {

                    if (amount > 100 - health) {
                        amountHealed = 100 - health;
                        health += amountHealed;
                    } else {
                        amountHealed = amount;
                        health += amountHealed;
                    }
                }
                System.out.printf("You healed for %d hp.%n", amountHealed);
                System.out.printf("Current health: %d hp.%n", health);

            } else if (command.equals("chest")) {
                totalBitcoins += amount;
                System.out.printf("You found %d bitcoins.%n", amount);
            } else {
                int monsterHp = amount;
                health -= monsterHp;

                if (health > 0) {
                    System.out.printf("You slayed %s.%n", command);
                } else {
                    System.out.printf("You died! Killed by %s.%n", command);
                    System.out.printf("Best room: %d", roomCount);
                    break;
                }
            }
        }
        if (health > 0) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", totalBitcoins);
            System.out.printf("Health: %d", health);
        }

    }
}
