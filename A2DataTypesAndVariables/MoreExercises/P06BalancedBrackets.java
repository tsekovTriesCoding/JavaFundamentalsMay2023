package A2DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        boolean unbalanced = true;
        int openingBracket = 0;
        int closingBracket = 0;
        boolean openBrc = false;


        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            if (input.equals("(")) {
                openingBracket++;
                openBrc = true;

            } else if (input.equals(")")) {
                closingBracket++;
                if (openBrc) {
                    unbalanced = false;
                }
            }
            if (closingBracket > openingBracket || openingBracket > closingBracket) {
                unbalanced = true;
            }

        }
        if (unbalanced) {
            System.out.println("UNBALANCED");
        } else {
            System.out.println("BALANCED");
        }
    }
}
