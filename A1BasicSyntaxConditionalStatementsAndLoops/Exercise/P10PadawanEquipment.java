package A1BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        int freeBelts = students / 6;

        double totalCost = lightsaberPrice * Math.ceil(students * 1.1) + robePrice * students +
                beltPrice * (students - freeBelts);

        if (totalCost <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalCost);
        } else {
            double diff = totalCost - budget;
            System.out.printf("George Lucas will need %.2flv more.", diff);
        }
    }
}
