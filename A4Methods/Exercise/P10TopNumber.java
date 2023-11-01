package A4Methods.Exercise;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            if (isSumOFDigitsDivisibleBy8(i) && isHoldingOneOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isSumOFDigitsDivisibleBy8(int num) {

        int sumOfDigits = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sumOfDigits += lastDigit;
            num = num / 10;
        }
        return sumOfDigits % 8 == 0;
    }

    public static boolean isHoldingOneOddDigit(int num) {

        while (num > 0) {
            int lastDigit = num % 10;

            if (lastDigit % 2 != 0) {
                return true;
            } else {
                num = num / 10;
            }
        }
        return false;
    }
}
