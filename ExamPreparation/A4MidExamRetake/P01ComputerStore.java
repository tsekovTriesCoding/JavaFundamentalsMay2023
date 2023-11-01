package ExamPreparation.A4MidExamRetake;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        double priceWithoutTaxes = 0;
        double taxes = 0;
        while (true) {
            if (command.equals("regular") || command.equals("special")) {
                break;
            }
            double partPrice = Double.parseDouble(command);

            if (partPrice < 0) {
                System.out.println("Invalid price!");
            } else {
                priceWithoutTaxes += partPrice;
                taxes += partPrice * 0.2;
            }
            command = scanner.nextLine();
        }

        double totalPrice = priceWithoutTaxes + taxes;
        if (command.equals("special")) {
            totalPrice = totalPrice * 0.9;
        }

        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPrice);
        }

    }
}
