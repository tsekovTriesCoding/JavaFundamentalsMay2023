package A1BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            password = password + username.charAt(i);
        }

        String inputPass = scanner.nextLine();
        int tryCount = 0;

        while (!inputPass.equals(password)) {
            tryCount++;
            if (tryCount == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");

            inputPass = scanner.nextLine();
        }

        if (inputPass.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
