package ExamPreparation.A8FinalExam;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Done")) {

            if (input.startsWith("TakeOdd")) {
                password = takeOdd(password);
            } else if (input.startsWith("Cut")) {
                password = cut(password, input);
            } else if (input.startsWith("Substitute")) {
                password = substitute(password, input);
            }

            input = scanner.nextLine();
        }

        System.out.println("Your password is: " + password);
    }

    private static String substitute(String password, String input) {
        String substring = input.split("\\s+")[1];
        String substitute = input.split("\\s+")[2];

        if (password.contains(substring)) {
            password = password.replace(substring, substitute);

            System.out.println(password);
        } else {
            System.out.println("Nothing to replace!");
        }
        return password;
    }

    private static String cut(String password, String input) {
        int index = Integer.parseInt(input.split("\\s+")[1]);
        int length = Integer.parseInt(input.split("\\s+")[2]);

        String substring = password.substring(index, index + length);
        password = password.replaceFirst(substring, "");

        System.out.println(password);
        return password;
    }

    private static String takeOdd(String password) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            if (i % 2 != 0) {
                sb.append(password.charAt(i));
            }
        }

        password = sb.toString();

        System.out.println(password);
        return password;
    }
}
