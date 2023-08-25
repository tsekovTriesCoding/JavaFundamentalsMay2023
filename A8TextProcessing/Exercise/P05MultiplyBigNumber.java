package A18ExerciseTextProcessing.Exercise;

import java.util.Scanner;

public class P05MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String reallyBigNumber = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());

        StringBuilder newNumber = new StringBuilder();
        int digitsLeft = 0;

        for (int index = reallyBigNumber.length() - 1; index >= 0; index--) {
            int digit = Integer.parseInt(String.valueOf(reallyBigNumber.charAt(index)));
            int result = digit * number;

            result += digitsLeft;
            newNumber.append(result % 10);
            digitsLeft = result / 10;
        }
        if (digitsLeft != 0) {
            newNumber.append(digitsLeft);
        }

        boolean zero = true;
        for (int i = 0; i < newNumber.length(); i++) {
            if (Integer.parseInt(newNumber.substring(i, i + 1)) != 0) {
                zero = false;
            }
        }
        if (zero) {
            System.out.println(0);
        } else {

            StringBuilder finalNum = new StringBuilder();
            boolean firstIsZero = true;
            for (int i = newNumber.length() - 1; i >= 0; i--) {
                if (Integer.parseInt(newNumber.substring(i, i + 1)) == 0 && firstIsZero) {

                } else {
                    firstIsZero = false;
                    finalNum.append(newNumber.charAt(i));
                }
            }

            System.out.println(finalNum);
        }
    }
}


