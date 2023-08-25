package A18ExerciseTextProcessing.Exercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] stringsArr = input.split("\\s+");

        double sum = 0;

        for (int i = 0; i <= stringsArr.length - 1; i++) {
            String current = stringsArr[i];
            char letterBefore = current.charAt(0);
            char letterAfter = current.charAt(current.length() - 1);

            double number = Double.parseDouble(stringsArr[i].replace(letterBefore, ' ')
                    .replace(letterAfter, ' ')
                    .trim());

            number = getResultOfLetterBefore(letterBefore, number);
            number = getResultOfLetterAfter(letterAfter, number);
            sum += number;
        }

        System.out.printf("%.2f", sum);
    }

    private static double getResultOfLetterBefore(char letterBefore, double number) {

        if (Character.isUpperCase(letterBefore)) {

            int positionUpperLetter = (int) letterBefore - 64;
            number = number / positionUpperLetter;

        } else {

            int positionLowerCase = (int) letterBefore - 96;
            number = number * positionLowerCase;

        }
        return number;
    }

    private static double getResultOfLetterAfter(char letterAfter, double number) {

        if (Character.isUpperCase(letterAfter)) {

            int positionUpperLetter = (int) letterAfter - 64;
            number = number - positionUpperLetter;

        } else {

            int positionLowerLetter = (int) letterAfter - 96;
            number = number + positionLowerLetter;

        }
        return number;
    }
}
