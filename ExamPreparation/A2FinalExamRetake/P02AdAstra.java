package ExamPreparation.A2FinalExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> validProducts = new ArrayList<>();

        String regex = "(\\||#)(?<itemName>[A-Za-z\\s]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\b([0-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-9][0-9][0-9][0-9]|10000)\\b)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int totalCalories = 0;
        while (matcher.find()) {
            totalCalories += Integer.parseInt(matcher.group("calories"));

            String product = String.format("Item: %s, Best before: %s, Nutrition: %s", matcher.group("itemName")
                    , matcher.group("expirationDate")
                    , matcher.group("calories"));

            validProducts.add(product);
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);

        for (String validProduct : validProducts) {
            System.out.println(validProduct);
        }
    }
}
