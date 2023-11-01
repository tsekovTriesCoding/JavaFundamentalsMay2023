package ExamPreparation.A06FinalExamRetake;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {

            if (input.startsWith("InsertSpace")) {
                message = insertSpace(message, input);
            } else if (input.startsWith("Reverse")) {
                message = reverse(message, input);
            } else if (input.startsWith("ChangeAll")) {
                message = changeAll(message, input);
            }

            input = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", message);

    }

    private static String changeAll(String message, String input) {
        String substring = input.split(":\\|:")[1];
        String replacement = input.split(":\\|:")[2];

        message = message.replace(substring, replacement);

        System.out.println(message);
        return message;
    }

    private static String reverse(String message, String input) {
        String substring = input.split(":\\|:")[1];
        if (message.contains(substring)) {
            StringBuilder sb = new StringBuilder(substring);
            message = message.replaceFirst(Pattern.quote(substring), "");
            sb.reverse();
            message = message + sb;

            System.out.println(message);
        } else {
            System.out.println("error");
        }
        return message;
    }

    private static String insertSpace(String message, String input) {
        int index = Integer.parseInt(input.split(":\\|:")[1]);

        StringBuilder sb = new StringBuilder(message);
        sb.insert(index, " ");
        message = sb.toString();

        System.out.println(message);
        return message;
    }
}
