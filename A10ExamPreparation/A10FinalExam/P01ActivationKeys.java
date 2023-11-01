package A10ExamPreparation.A10FinalExam;

import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rawActivationKey = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {

            if (input.contains("Contains")) {
                contains(rawActivationKey, input);
            } else if (input.contains("Flip")) {
                rawActivationKey = flip(rawActivationKey, input);
            } else if (input.contains("Slice")) {
                rawActivationKey = slice(rawActivationKey, input);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s", rawActivationKey);

    }

    private static void contains(String rawActivationKey, String input) {
        String substringToCheck = input.split(">>>")[1];

        if (rawActivationKey.contains(substringToCheck)) {
            System.out.printf("%s contains %s%n", rawActivationKey, substringToCheck);
        } else {
            System.out.println("Substring not found!");
        }
    }

    private static String slice(String rawActivationKey, String input) {
        int startIndex = Integer.parseInt(input.split(">>>")[1]);
        int endIndex = Integer.parseInt(input.split(">>>")[2]);

        StringBuilder sb = new StringBuilder(rawActivationKey);
        sb.delete(startIndex, endIndex);

        rawActivationKey = sb.toString();

        System.out.println(rawActivationKey);
        return rawActivationKey;
    }

    private static String flip(String rawActivationKey, String input) {
        String casing = input.split(">>>")[1];
        int startIndex = Integer.parseInt(input.split(">>>")[2]);
        int endIndex = Integer.parseInt(input.split(">>>")[3]);

        String partToChange = rawActivationKey.substring(startIndex, endIndex);
        StringBuilder sb = new StringBuilder(rawActivationKey);
        if (casing.equals("Upper")) {
            sb.delete(startIndex, endIndex);
            sb.insert(startIndex, partToChange.toUpperCase());
        } else {
            sb.delete(startIndex, endIndex);
            sb.insert(startIndex, partToChange.toLowerCase());
        }

        rawActivationKey = sb.toString();

        System.out.println(rawActivationKey);
        return rawActivationKey;
    }
}
