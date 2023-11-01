package A4Methods.Exercise;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            if (isPalindrome(command)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            command = scanner.nextLine();
        }
    }

    public static boolean isPalindrome(String command) {
        String reversedCommand = "";

        for (int index = command.length() - 1; index >= 0; index--) {
            reversedCommand += command.charAt(index);
        }
        return command.equals(reversedCommand);
    }
}
