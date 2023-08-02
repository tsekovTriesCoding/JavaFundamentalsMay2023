package A9ExerciseMethods.Exercises;

import java.util.Scanner;
import java.util.SimpleTimeZone;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printCountOfVowels(input);
    }

    public static void printCountOfVowels(String input) {

        input = input.toLowerCase();
        int vowelsCount = 0;
        for (int i = 0; i <= input.length() - 1; i++) {


            if (input.charAt(i) == 'a') {
                vowelsCount++;
            } else if (input.charAt(i) == 'e') {
                vowelsCount++;
            } else if (input.charAt(i) == 'o') {
                vowelsCount++;
            } else if (input.charAt(i) == 'u') {
                vowelsCount++;
            } else if (input.charAt(i) == 'i') {
                vowelsCount++;
            }
        }

        System.out.println(vowelsCount);
    }
}
