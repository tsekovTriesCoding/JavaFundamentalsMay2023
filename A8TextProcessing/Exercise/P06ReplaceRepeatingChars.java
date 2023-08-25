package A18ExerciseTextProcessing.Exercise;

import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder output = new StringBuilder(input);

        for (int i = 0; i < output.length() - 1; i++) {
            if (output.charAt(i) == output.charAt(i + 1)) {
                output.deleteCharAt(i + 1);
                i--;
            }

        }
        System.out.println(output);
    }
}
