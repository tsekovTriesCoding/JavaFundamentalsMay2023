package A18ExerciseTextProcessing.Exercise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder encryptedMessage = new StringBuilder();

        for (char symbol : input.toCharArray()) {
            symbol += 3;
            encryptedMessage.append(symbol);
        }

        System.out.println(encryptedMessage);
    }
}
