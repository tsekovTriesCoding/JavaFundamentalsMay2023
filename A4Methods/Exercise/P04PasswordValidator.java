package A4Methods.Exercise;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!isValidLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!isValidContent(password)) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!isValidCountOfDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isValidLength( password) && isValidContent(password) && isValidCountOfDigits(password)) {
            System.out.println("Password is valid");
        }
    }

    public static boolean isValidLength(String password) {

        return password.length() >= 6 && password.length() <= 10;
    }

    public static boolean isValidContent(String password) {
        for (char symbol : password.toCharArray()) {

            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidCountOfDigits(String password) {

        int digitsCount = 0;
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                digitsCount++;
            }
        }

        return digitsCount >= 2;
    }
}

