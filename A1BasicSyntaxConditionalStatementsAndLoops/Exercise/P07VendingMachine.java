package A1BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double coinsSum = 0;

        while (!command.equals("Start")) {
            double coins = Double.parseDouble(command);
            if (coins != 0.1 && coins != 0.2 && coins != 0.5 && coins != 1 && coins != 2) {
                System.out.printf("Cannot accept %.2f%n", coins);
            } else {
                coinsSum += coins;
            }

            command = scanner.nextLine();
        }

        String command2 = scanner.nextLine();

        double price = 0;

        while (!command2.equals("End")) {
            String product = command2;
            boolean noMoney = false;

            switch (product) {
                case "Nuts":
                    price = 2.0;
                    if (coinsSum >= price) {
                        System.out.printf("Purchased %s%n", product);
                        coinsSum -= price;
                    } else {
                        noMoney = true;
                    }
                    break;
                case "Water":
                    price = 0.7;
                    if (coinsSum >= price) {
                        System.out.printf("Purchased %s%n", product);
                        coinsSum -= price;
                    } else {
                        noMoney = true;
                    }
                    break;
                case "Crisps":
                    price = 1.5;
                    if (coinsSum >= price) {
                        System.out.printf("Purchased %s%n", product);
                        coinsSum -= price;
                    } else {
                        noMoney = true;
                    }
                    break;
                case "Soda":
                    price = 0.8;
                    if (coinsSum >= price) {
                        System.out.printf("Purchased %s%n", product);
                        coinsSum -= price;
                    } else {
                        noMoney = true;
                    }
                    break;
                case "Coke":
                    price = 1.0;
                    if (coinsSum >= price) {
                        System.out.printf("Purchased %s%n", product);
                        coinsSum -= price;
                    } else {
                        noMoney = true;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            if (noMoney) {
                System.out.println("Sorry, not enough money");
                System.out.println();
            }

            command2 = scanner.nextLine();
        }

        if (command2.equals("End")) {
            System.out.printf("Change: %.2f", coinsSum);
        }
    }
}
