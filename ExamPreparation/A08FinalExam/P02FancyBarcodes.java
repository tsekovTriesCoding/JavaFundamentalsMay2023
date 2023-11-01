package ExamPreparation.A08FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "@#+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                System.out.println("Invalid barcode");
            } else {
                StringBuilder group = new StringBuilder();
                for (char symbol : matcher.group("product").toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        group.append(symbol);
                    }
                }

                if (group.toString().isEmpty()) {
                    group.append("00");
                }

                System.out.printf("Product group: %s%n", group);
            }
        }
    }
}
