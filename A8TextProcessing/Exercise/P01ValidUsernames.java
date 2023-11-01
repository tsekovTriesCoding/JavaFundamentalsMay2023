package A8TextProcessing.Exercise;

import java.util.Scanner;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernamesArr = scanner.nextLine().split(", ");

        for (String username : usernamesArr) {
            if (isValidLength(username) && isValidContent(username)) {
                System.out.println(username);
            }
        }
    }

    public static boolean isValidLength(String username) {

        return username.length() >= 3 && username.length() <= 16;
    }

    public static boolean isValidContent(String username) {

        for (char symbol : username.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }
        return true;
    }
}
