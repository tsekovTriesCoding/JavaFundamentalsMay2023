package A9RegularExpressions.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        List<String> goodChildrenList = new ArrayList<>();

        while (!input.equals("end")) {
            StringBuilder decryptedMessageSb = new StringBuilder();

            for (char symbol : input.toCharArray()) {
                char newSymbol = (char) (symbol - key);
                decryptedMessageSb.append(newSymbol);
            }

            String decryptedMessage = decryptedMessageSb.toString();
            String regex = "@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<behavior>[A-Z])!";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);

            if (matcher.find()) {
                String name = matcher.group("name");
                String behavior = matcher.group("behavior");

                if (behavior.equals("G")) {
                    goodChildrenList.add(name);
                }
            }

            input = scanner.nextLine();
        }

        goodChildrenList.forEach(System.out::println);
    }
}
