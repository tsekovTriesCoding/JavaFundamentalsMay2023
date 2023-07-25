package A4ExerciseDataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        String message = "";

        for (int i = 1; i <= n; i++) {
            char symbol = scanner.nextLine().charAt(0);

            message += (char) (symbol + key);
        }
        System.out.println(message);
    }
}
