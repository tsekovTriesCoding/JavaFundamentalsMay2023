package A20ExerciseRegularExpressions.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06ValidatePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String passwordRegex = "\\_\\.+[A-Z][A-Za-z\\d]{4,}[A-Z]\\_\\.+";
        Pattern pattern = Pattern.compile(passwordRegex);

        for (int i = 1; i <= n; i++) {
            String password = scanner.nextLine();

            Matcher matcher = pattern.matcher(password);

            if (matcher.find()) {
                String currentPass = matcher.group();

                StringBuilder groupSb = new StringBuilder();
                for (char symbol : currentPass.toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        groupSb.append(symbol);
                    }
                }

                String group = groupSb.toString();
                if (group.isBlank()) {
                    group = "default";
                }

                System.out.printf("Group: %s%n", group);
            } else {
                System.out.println("Invalid pass!");
            }
        }
    }
}
