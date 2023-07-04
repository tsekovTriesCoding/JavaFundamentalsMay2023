package A2ExerciseBasicSyntaxConditionalStatementsAndLoops.Exercises;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int factorialSum = 0;
        int startNum = num;

        while (num > 0) {
            int lastDigit = num % 10;

            int factorial = 1;
            for (int i = 1; i <= lastDigit; i++) {
                factorial = factorial * i;
            }
            factorialSum += factorial;

            num = num / 10;
        }

        if (factorialSum == startNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
