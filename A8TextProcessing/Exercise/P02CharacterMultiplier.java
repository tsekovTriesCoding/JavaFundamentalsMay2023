package A18ExerciseTextProcessing.Exercise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String string1 = input.split("\\s+")[0];
        String string2 = input.split("\\s+")[1];

        int minLength = Math.min(string1.length(), string2.length());
        int maxLength = Math.max(string1.length(), string2.length());

        int sumOfCharCodes = 0;

        for (int index = 0; index < minLength; index++) {
            sumOfCharCodes += (string1.charAt(index) * string2.charAt(index));
        }

        sumOfCharCodes = getSumOfLeftSymbols(string1, string2, minLength, maxLength, sumOfCharCodes);

        System.out.println(sumOfCharCodes);
    }

    private static int getSumOfLeftSymbols(String string1, String string2, int minLength, int maxLength, int sumOfCharCodes) {
        if (string1.length() == maxLength) {
            for (int index = minLength; index < string1.length(); index++) {
                sumOfCharCodes += string1.charAt(index);
            }
        } else {
            for (int index = minLength; index < string2.length(); index++) {
                sumOfCharCodes += string2.charAt(index);
            }
        }
        return sumOfCharCodes;
    }
}
