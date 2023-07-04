package A2ExerciseBasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double totalPrice = 0;

        if (groupType.equals("Students")) {
            if (dayOfWeek.equals("Friday")) {
                totalPrice = 8.45 * peopleCount;
            } else if (dayOfWeek.equals("Saturday")) {
                totalPrice = 9.80 * peopleCount;
            } else if (dayOfWeek.equals("Sunday")) {
                totalPrice = 10.46 * peopleCount;
            }

            if (peopleCount >= 30) {
                totalPrice = totalPrice * 0.85;
            }
        } else if (groupType.equals("Business")) {

            if (peopleCount >= 100) {
                peopleCount -= 10;
            }
            if (dayOfWeek.equals("Friday")) {
                totalPrice = 10.90 * peopleCount;
            } else if (dayOfWeek.equals("Saturday")) {
                totalPrice = 15.60 * peopleCount;
            } else if (dayOfWeek.equals("Sunday")) {
                totalPrice = 16 * peopleCount;
            }

        } else if (groupType.equals("Regular")) {
            if (dayOfWeek.equals("Friday")) {
                totalPrice = 15 * peopleCount;
            } else if (dayOfWeek.equals("Saturday")) {
                totalPrice = 20 * peopleCount;
            } else if (dayOfWeek.equals("Sunday")) {
                totalPrice = 22.50 * peopleCount;
            }

            if (peopleCount >= 10 && peopleCount <= 20) {
                totalPrice = totalPrice * 0.95;
            }
        }

        System.out.printf("Total price: %.2f", totalPrice);

    }
}
