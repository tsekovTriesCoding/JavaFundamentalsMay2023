package A1BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());

        double price = 0;
        double totalCost = 0;

        String command = scanner.nextLine();

        while (!command.equals("Game Time")) {

            boolean bought = false;

            if (command.equals("OutFall 4")) {
                price = 39.99;

                if (price <= currentBalance) {
                    bought = true;
                    currentBalance -= price;
                    totalCost += price;
                }
            } else if (command.equals("CS: OG")) {
                price = 15.99;

                if (price <= currentBalance) {
                    bought = true;
                    currentBalance -= price;
                    totalCost += price;
                }
            } else if (command.equals("Zplinter Zell")) {
                price = 19.99;

                if (price <= currentBalance) {
                    bought = true;
                    currentBalance -= price;
                    totalCost += price;
                }
            } else if (command.equals("Honored 2")) {
                price = 59.99;

                if (price <= currentBalance) {
                    bought = true;
                    currentBalance -= price;
                    totalCost += price;
                }
            } else if (command.equals("RoverWatch")) {
                price = 29.99;

                if (price <= currentBalance) {
                    bought = true;
                    currentBalance -= price;
                    totalCost += price;
                }
            } else if (command.equals("RoverWatch Origins Edition")) {
                price = 39.99;

                if (price <= currentBalance) {
                    bought = true;
                    currentBalance -= price;
                    totalCost += price;
                }
            } else {
                System.out.println("Not Found");
            }

            if (bought) {
                System.out.printf("Bought %s%n", command);
            } else {
                System.out.println("Too Expensive");
            }

            if (currentBalance == 0) {
                System.out.println("Out of money!");
                break;
            }

            command = scanner.nextLine();
        }

        if (command.equals("Game Time")) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalCost, currentBalance);
        }
    }
}
