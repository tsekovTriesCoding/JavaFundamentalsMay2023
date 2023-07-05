package A2ExerciseBasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class P05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lettersCount = Integer.parseInt(scanner.nextLine());

        String message = "";

        for (int i = 1; i <= lettersCount; i++) {
            int numberEntered = Integer.parseInt(scanner.nextLine());

            int digitCount = String.valueOf(numberEntered).length();
            int mainDigit = Integer.toString(numberEntered).charAt(0) - 48;
            int numOffset = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                numOffset += 1;
            }
            int letterIndex = (numOffset + digitCount - 1);

            if (letterIndex < 0) {
                System.out.print(" ");
            } else {
                System.out.printf("%c", letterIndex + 97);
            }
        }

    }
}
