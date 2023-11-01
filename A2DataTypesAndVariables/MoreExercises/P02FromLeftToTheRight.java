package A2DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String numbers = scanner.nextLine();

            String[] nums = numbers.split(" ");
            String num1 = nums[0];
            String num2 = nums[1];

            long num1Parsed = Long.parseLong(num1);
            long num2Parsed = Long.parseLong(num2);

            long biggestNum = Math.max(num1Parsed, num2Parsed);

            int sumOfDigits = 0;
            while (biggestNum != 0) {
                sumOfDigits += biggestNum % 10;
                biggestNum /= 10;
            }

            System.out.println(Math.abs(sumOfDigits));
        }
    }
}

