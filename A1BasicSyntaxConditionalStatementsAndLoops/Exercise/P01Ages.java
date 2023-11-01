package A1BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P01Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        String personType = "";

        if (age >= 0 && age <= 2) {
            personType = "baby";
        } else if (age > 2 && age <= 13) {
            personType = "child";
        } else if (age > 13 && age <= 19) {
            personType = "teenager";
        } else if (age > 19 && age <= 65) {
            personType = "adult";
        } else if (age > 65) {
            personType = "elder";
        }

        System.out.println(personType);
    }
}
