package A9ExerciseMethods.Exercises;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMidCharacter(input);
    }

    public static void printMidCharacter(String input) {

        String midCharacter = "";
        if (input.length() % 2 != 0) {
            midCharacter += input.charAt(input.length() / 2);
        } else {
            midCharacter += input.charAt(input.length() / 2 - 1);
            midCharacter += input.charAt(input.length() / 2);
        }

        System.out.println(midCharacter);
    }
}
