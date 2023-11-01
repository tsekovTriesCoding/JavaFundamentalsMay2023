package A1BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class P10MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int multiplier = 1;


        while (multiplier <= 10) {
            int result = 0;
            result = n * multiplier;

            System.out.printf("%d X %d = %d%n", n, multiplier, result);

            multiplier++;
        }
    }
}
