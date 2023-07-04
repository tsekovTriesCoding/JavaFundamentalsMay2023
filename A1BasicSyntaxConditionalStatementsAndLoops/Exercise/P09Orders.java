package A2ExerciseBasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int i = 1; i <= n; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            double currentPrice = pricePerCapsule * days * capsulesCount;

            System.out.printf("The price for the coffee is: $%.2f%n", currentPrice);
            totalPrice += currentPrice;
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
