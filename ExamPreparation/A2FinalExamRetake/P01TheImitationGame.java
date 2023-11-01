package ExamPreparation.A2FinalExamRetake;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {

            if (input.startsWith("Move")) {
                encryptedMessage = moveLetters(encryptedMessage, input);
            } else if (input.startsWith("Insert")) {
                encryptedMessage = insertValue(encryptedMessage, input);
            } else if (input.startsWith("ChangeAll")) {
                encryptedMessage = changeAll(encryptedMessage, input);
            }

            input = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", encryptedMessage);
    }

    private static String changeAll(String encryptedMessage, String input) {
        String substring = input.split("\\|")[1];
        String replacement = input.split("\\|")[2];

        encryptedMessage = encryptedMessage.replace(substring, replacement);
        return encryptedMessage;
    }

    private static String insertValue(String encryptedMessage, String input) {
        int index = Integer.parseInt(input.split("\\|")[1]);
        String value = input.split("\\|")[2];
        StringBuilder sb = new StringBuilder(encryptedMessage);

        sb.insert(index, value);
        encryptedMessage = sb.toString();
        return encryptedMessage;
    }

    private static String moveLetters(String encryptedMessage, String input) {
        int count = Integer.parseInt(input.split("\\|")[1]);
        String newSubstring = encryptedMessage.substring(0, count);
        StringBuilder sb = new StringBuilder(encryptedMessage);

        sb.delete(0, count);
        sb.append(newSubstring);

        encryptedMessage = sb.toString();
        return encryptedMessage;
    }
}
