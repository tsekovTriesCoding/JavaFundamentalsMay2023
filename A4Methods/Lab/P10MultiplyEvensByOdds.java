package A4Methods.Lab;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(multiplyEvensByOdds(number));
    }

    public static int multiplyEvensByOdds(int number) {

        int oddDigitsSum = 0;
        int evenDigitsSum = 0;
        number = Math.abs(number);

        while (number > 0) {
            int lastDigit = number % 10;

            if (lastDigit % 2 == 0) {
                evenDigitsSum += lastDigit;
            } else {
                oddDigitsSum += lastDigit;
            }

            number = number / 10;
        }

        return evenDigitsSum * oddDigitsSum;
    }
}
